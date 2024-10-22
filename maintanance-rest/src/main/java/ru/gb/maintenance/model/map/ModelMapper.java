package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.dto.ModelDto;
import ru.gb.maintenance.service.CompanyServiceImpl;
import ru.gb.maintenance.service.ManufacturerServiceImpl;


@Mapper(config = MappingConfiguration.class, uses = {ManufacturerServiceImpl.class})
public interface ModelMapper extends BaseMapper<Model, ModelDto> {
    @Mapping(source = "manufacturer.id", target = "manufacturerId")
    ModelDto toDto(Model model);

    @Mapping(source = "manufacturerId", target = "manufacturer")
    Model toEntity(ModelDto dto);

}
