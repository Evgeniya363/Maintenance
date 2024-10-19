package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;

@Mapper(config = MappingConfiguration.class)
public interface EquipmentMapper extends BaseMapper<Equipment, EquipmentDto> {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "employee.name", target = "employeeName")
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "department.name", target = "departmentName")
    EquipmentDto toDto(Equipment equipment);
}
