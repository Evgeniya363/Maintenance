package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dtos.ModelDto;
import ru.gb.maintenance.services.ManufacturerServiceImpl;


@Mapper(config = MappingConfiguration.class, uses = {ManufacturerServiceImpl.class})
public interface ModelMapper extends BaseMapper<Model, ModelDto> {
    @Mapping(source = "manufacturer.id", target = "manufacturerId")
    ModelDto toDto(Model model);

    @Mapping(source = "manufacturerId", target = "manufacturer")
    Model toEntity(ModelDto dto);

}
