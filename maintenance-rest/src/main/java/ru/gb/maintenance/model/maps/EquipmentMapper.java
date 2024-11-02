package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.services.*;

@Mapper(config = MappingConfiguration.class, uses = {DepartmentServiceImpl.class, EmployeeServiceImpl.class, CategoryServiceImpl.class, ModelService.class})
public interface EquipmentMapper extends BaseMapper<Equipment, EquipmentDto> {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "model.id", target = "modelId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "department.id", target = "departmentId")
//    @Mapping(source = "serialNumber", target = "serial_number")
//    @Mapping(source = "inventoryNumber", target = "inventory_number")
//    @Mapping(source = "serviceNumber", target = "service_number")
//    @Mapping(source = "startUsageDate", target = "start_usage_date")
//    @Mapping(source = "maintenanceDate", target = "maintenance_date")
    EquipmentDto toDto(Equipment equipment);

    @Mapping(source = "categoryId", target = "category")
    @Mapping(source = "modelId", target = "model")
    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "departmentId", target = "department")
//    @Mapping(source = "serial_number", target = "serialNumber")
//    @Mapping(source = "inventory_number", target = "inventoryNumber")
//    @Mapping(source = "service_number", target = "serviceNumber")
//    @Mapping(source = "start_usage_date", target = "startUsageDate")
//    @Mapping(source = "maintenance_date", target = "maintenanceDate")
    Equipment toEntity(EquipmentDto equipment);
}

