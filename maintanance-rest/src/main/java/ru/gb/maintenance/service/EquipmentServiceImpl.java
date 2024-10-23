package ru.gb.maintenance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.model.map.EquipmentMapper;
import ru.gb.maintenance.model.criteria.EquipmentCriteria;
import ru.gb.maintenance.repositiry.EquipmentRepository;
import ru.gb.maintenance.repositiry.EquipmentSpecification;

import java.util.List;

@Service
public class EquipmentServiceImpl extends BaseEntityServiceImpl<Equipment, EquipmentDto, EquipmentMapper> implements EquipmentService {
    private final EquipmentRepository repository;
    private final EquipmentMapper mapper;
    @Autowired
    EquipmentSpecification specification;


    public EquipmentServiceImpl(EquipmentRepository equipmentRepository, EquipmentMapper mapper, EquipmentRepository repository) {
        super(equipmentRepository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    @Override
    public List<EquipmentDto> findByCategoryId(Long id) {
        return mapper.toDtoS(repository.findByCategoryId(id));
    }

    @GetMapping
    @Override
    public List<EquipmentDto> findByEmployeeId(Long id) {
        return mapper.toDtoS(repository.findByEmployeeId(id));
    }

    @Override
    public List<EquipmentDto> findByDepartmentId(Long id) {
        return mapper.toDtoS(repository.findByDepartmentId(id));
    }

    @Override
    public List<EquipmentDto> findByModelId(Long id) {
        return mapper.toDtoS(repository.findByModelId(id));
    }

    @Override
    public List<EquipmentDto> findByCompanyId(Long id) {
        return mapper.toDtoS(repository.findByCompanyId(id));
    }

    @Override
    public List<EquipmentDto> findByManufacturerId(Long id) {
        return mapper.toDtoS(repository.findByManufacturerId(id));
    }

    @Override
    public List<EquipmentDto> findByCriteria(EquipmentCriteria params) { //Long companyId, Long departmentId, Long manufacturerId, Long modelId, Long categoryId, Long employeeId) {

        Specification<Equipment> spec = specification.build(params);
        return repository.findAll(spec).stream().map(mapper::toDto).toList();

    }

    // List<Customer> customers = customerRepository.findAll(
    //        where(isLongTermCustomer()).or(hasSalesOfMoreThan(amount)));
}
