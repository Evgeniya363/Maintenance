package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.dtos.ManufacturerDto;

@Mapper(config = MappingConfiguration.class)
public interface ManufacturerMapper extends BaseMapper<Manufacturer, ManufacturerDto> {
//    ManufacturerDto toDto(Manufacturer manufacturer);
}