package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.services.*;


@Mapper(config = MappingConfiguration.class,
        uses = {EquipmentServiceImpl.class, EmployeeServiceImpl.class})
public interface MaintenanceMapper extends BaseMapper<Maintenance, MaintenanceDto> {
    @Mapping(source = "equipment.id", target = "equipmentId")
    @Mapping(source = "contractor.id", target = "contractorId", ignore = true)
    MaintenanceDto toDto(Maintenance entity);

    @Mapping(source = "equipmentId", target = "equipment")
    @Mapping(source = "contractorId", target = "contractor", ignore = true)
    Maintenance toEntity(MaintenanceDto dto);

    // Пример:
//    @Mapper(componentModel = "spring", uses = { PersonService.class })
//    public interface SchoolMapper extends EntityMapper<SchoolDTO, School>{
//
//        @Mapping(source = "personId", target = "person")
//        School toEntity(SchoolDTO schoolDTO);
//    }

}
