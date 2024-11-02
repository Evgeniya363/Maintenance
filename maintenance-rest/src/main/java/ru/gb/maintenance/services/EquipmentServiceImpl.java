package ru.gb.maintenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.model.maps.EquipmentMapper;
import ru.gb.maintenance.repositories.criteria.EquipmentCriteria;
import ru.gb.maintenance.repositories.EquipmentRepository;
import ru.gb.maintenance.repositories.specifications.EquipmentSpecification;

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
        return mapper.toDtoList(repository.findByCategoryId(id));
    }

    @GetMapping
    @Override
    public List<EquipmentDto> findByEmployeeId(Long id) {
        return mapper.toDtoList(repository.findByEmployeeId(id));
    }

    @Override
    public List<EquipmentDto> findByDepartmentId(Long id) {
        return mapper.toDtoList(repository.findByDepartmentId(id));
    }

    @Override
    public List<EquipmentDto> findByModelId(Long id) {
        return mapper.toDtoList(repository.findByModelId(id));
    }

    @Override
    public List<EquipmentDto> findByCompanyId(Long id) {
        return mapper.toDtoList(repository.findByCompanyId(id));
    }

    @Override
    public List<EquipmentDto> findByManufacturerId(Long id) {
        return mapper.toDtoList(repository.findByManufacturerId(id));
    }

    @Override
    public List<Equipment> findByCriteria(EquipmentCriteria params) {
        Specification<Equipment> spec = specification.build(params);
        return repository.findAll(spec);
    }

}
