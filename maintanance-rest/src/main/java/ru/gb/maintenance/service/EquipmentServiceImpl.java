package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.model.map.EquipmentMapper;
import ru.gb.maintenance.repositiry.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentServiceImpl extends BaseEntityServiceImpl<Equipment, EquipmentDto, EquipmentMapper> implements EquipmentService {
    private final EquipmentRepository repository;
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository, EquipmentMapper mapper, EquipmentRepository repository) {
        super(equipmentRepository, mapper);
        this.repository = repository;
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
}
