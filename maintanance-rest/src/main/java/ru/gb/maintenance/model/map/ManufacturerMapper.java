package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.dto.ManufacturerDto;

@Mapper(config = MappingConfiguration.class)
public interface ManufacturerMapper extends BaseMapper<Manufacturer, ManufacturerDto> {
//    ManufacturerDto toDto(Manufacturer manufacturer);
}