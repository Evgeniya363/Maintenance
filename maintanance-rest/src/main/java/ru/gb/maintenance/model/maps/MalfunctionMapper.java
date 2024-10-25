package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Malfunction;
import ru.gb.maintenance.model.dtos.MalfunctionDto;
import ru.gb.maintenance.services.*;

@Mapper(config = MappingConfiguration.class, uses = MaintenanceServiceImpl.class)
public interface MalfunctionMapper extends BaseMapper<Malfunction, MalfunctionDto> {

    @Mapping(source = "maintenance.id", target = "maintenanceId")
    MalfunctionDto toDto(Malfunction malfunction);

    @Mapping(source = "maintenanceId", target = "maintenance")
    Malfunction toEntity(MalfunctionDto dto);
}
