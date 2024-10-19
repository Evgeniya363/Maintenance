package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;

import java.util.List;
import java.util.Optional;

@Service
public interface EquipmentService extends BaseEntityService<Equipment, EquipmentDto> {
    List<EquipmentDto> findByCategoryId(Long id);

    List<EquipmentDto> findByEmployeeId(Long id);

    List<EquipmentDto> findByDepartmentId(Long id);
}
