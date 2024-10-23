package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.model.criteria.EquipmentCriteria;

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
