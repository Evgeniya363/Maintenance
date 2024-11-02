package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.services.*;

@Mapper(config = MappingConfiguration.class,
        uses = {DepartmentServiceImpl.class,
                EmployeeServiceImpl.class,
                CategoryServiceImpl.class,
                ModelService.class}
)
public interface EquipmentMapper extends BaseMapper<Equipment, EquipmentDto> {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "model.id", target = "modelId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "department.id", target = "departmentId")
    EquipmentDto toDto(Equipment equipment);

    @Mapping(source = "categoryId", target = "category")
    @Mapping(source = "modelId", target = "model")
    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "departmentId", target = "department")
    Equipment toEntity(EquipmentDto equipment);
}

