package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.services.*;


@Mapper(config = MappingConfiguration.class, uses = {EquipmentServiceImpl.class, EmployeeServiceImpl.class})
public interface MaintenanceMapper extends BaseMapper<Maintenance, MaintenanceDto> {
    @Mapping(source = "equipment.id", target = "equipmentId")
    @Mapping(source = "contractor.id", target = "contractorId")
//    @Mapping(source = "type.id", target = "type_id")
//    @Mapping(source = "status.id", target = "status_id")
//    @Mapping(source = "result.id", target = "result_id")
    MaintenanceDto toDto(Maintenance entity);

    @Mapping(source = "equipmentId", target = "equipment")
    @Mapping(source = "contractorId", target = "contractor")
//    @Mapping(source = "typeId", target = "type")
//    @Mapping(source = "statusId", target = "status")
//    @Mapping(source = "resultId", target = "result")
    Maintenance toEntity(MaintenanceDto dto);

    // Пример:
//    @Mapper(componentModel = "spring", uses = { PersonService.class })
//    public interface SchoolMapper extends EntityMapper<SchoolDTO, School>{
//
//        @Mapping(source = "personId", target = "person")
//        School toEntity(SchoolDTO schoolDTO);
//    }

}
