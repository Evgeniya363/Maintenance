package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.dto.CategoryDto;

@Mapper(config = MappingConfiguration.class)
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {

    CategoryDto toDto(Category category);

}
