package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.services.*;


@Mapper(config = MappingConfiguration.class
        , uses = {EquipmentServiceImpl.class, ContractorServiceImpl.class}
        , unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface MaintenanceMapper extends BaseMapper<Maintenance, MaintenanceDto> {
    @Mapping(source = "equipment.id", target = "equipmentId")
    @Mapping(source = "contractor.id", target = "contractorId")
    MaintenanceDto toDto(Maintenance entity);

    @Mapping(source = "equipmentId", target = "equipment")
    @Mapping(source = "contractorId", target = "contractor")
    Maintenance toEntity(MaintenanceDto dto);

}
