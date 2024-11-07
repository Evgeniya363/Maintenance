package ru.gb.maintenance.model.maps;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dtos.ModelDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T20:38:51+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ModelMapperImpl implements ModelMapper {

    @Override
    public List<ModelDto> toDtoList(List<Model> listT) {
        if ( listT == null ) {
            return null;
        }

        List<ModelDto> list = new ArrayList<ModelDto>( listT.size() );
        for ( Model model : listT ) {
            list.add( toDto( model ) );
        }

        return list;
    }

    @Override
    public ModelDto toDto(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelDto modelDto = new ModelDto();

        modelDto.setManufacturerId( modelManufacturerId( model ) );
        modelDto.setId( model.getId() );
        modelDto.setName( model.getName() );

        return modelDto;
    }

    @Override
    public Model toEntity(ModelDto dto) {
        if ( dto == null ) {
            return null;
        }

        Model model = new Model();

        model.setId( dto.getId() );
        model.setName( dto.getName() );

        return model;
    }

    private Long modelManufacturerId(Model model) {
        Manufacturer manufacturer = model.getManufacturer();
        if ( manufacturer == null ) {
            return null;
        }
        return manufacturer.getId();
    }
}
