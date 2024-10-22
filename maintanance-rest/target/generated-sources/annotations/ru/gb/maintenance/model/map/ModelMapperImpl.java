package ru.gb.maintenance.model.map;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dto.ModelDto;
import ru.gb.maintenance.service.ManufacturerServiceImpl;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T12:23:44+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ModelMapperImpl implements ModelMapper {

    @Autowired
    private ManufacturerServiceImpl manufacturerServiceImpl;

    @Override
    public List<ModelDto> toDtoS(List<Model> listT) {
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

        model.setManufacturer( manufacturerServiceImpl.getObjectById( dto.getManufacturerId() ) );
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
