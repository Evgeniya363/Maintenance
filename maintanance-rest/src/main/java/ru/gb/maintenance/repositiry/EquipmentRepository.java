package ru.gb.maintenance.repositiry;

import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends BaseEntityRepository<Equipment> {
    List<Equipment> findByCategoryId(Long id);

    List<Equipment> findByEmployeeId(Long id);

    List<Equipment> findByDepartmentId(Long id);
}
