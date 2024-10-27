package ru.gb.maintenance.model.maps;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.dtos.ManufacturerDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T22:01:40+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ManufacturerMapperImpl implements ManufacturerMapper {

    @Override
    public ManufacturerDto toDto(Manufacturer t) {
        if ( t == null ) {
            return null;
        }

        ManufacturerDto manufacturerDto = new ManufacturerDto();

        manufacturerDto.setId( t.getId() );
        manufacturerDto.setName( t.getName() );

        return manufacturerDto;
    }

    @Override
    public Manufacturer toEntity(ManufacturerDto d) {
        if ( d == null ) {
            return null;
        }

        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setId( d.getId() );
        manufacturer.setName( d.getName() );

        return manufacturer;
    }

    @Override
    public List<ManufacturerDto> toDtoS(List<Manufacturer> listT) {
        if ( listT == null ) {
            return null;
        }

        List<ManufacturerDto> list = new ArrayList<ManufacturerDto>( listT.size() );
        for ( Manufacturer manufacturer : listT ) {
            list.add( toDto( manufacturer ) );
        }

        return list;
    }
}
