package ru.gb.maintenance.model.maps;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.dtos.CategoryDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T20:38:51+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toDto(Category t) {
        if ( t == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( t.getId() );
        categoryDto.setName( t.getName() );

        return categoryDto;
    }

    @Override
    public Category toEntity(CategoryDto d) {
        if ( d == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( d.getId() );
        category.setName( d.getName() );

        return category;
    }

    @Override
    public List<CategoryDto> toDtoList(List<Category> listT) {
        if ( listT == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( listT.size() );
        for ( Category category : listT ) {
            list.add( toDto( category ) );
        }

        return list;
    }
}
