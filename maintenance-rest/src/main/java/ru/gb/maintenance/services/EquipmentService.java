package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.repositories.criteria.EquipmentCriteria;

import java.util.List;

@Service
public interface EquipmentService extends BaseEntityService<Equipment, EquipmentDto> {
    List<EquipmentDto> findByCategoryId(Long id);

    List<EquipmentDto> findByEmployeeId(Long id);

    List<EquipmentDto> findByDepartmentId(Long id);

    List<EquipmentDto> findByModelId(Long id);

    List<EquipmentDto> findByCompanyId(Long id);

    List<EquipmentDto> findByManufacturerId(Long id);

//    List<EquipmentDto> findByCriteria(Long companyId, Long departmentId, Long manufacturerId, Long modelId, Long categoryId, Long employeeId);
    List<EquipmentDto> findByCriteria(EquipmentCriteria parameters);

}
