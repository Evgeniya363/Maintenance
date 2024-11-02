package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.dtos.CategoryDto;

@Mapper(config = MappingConfiguration.class)
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {

}
