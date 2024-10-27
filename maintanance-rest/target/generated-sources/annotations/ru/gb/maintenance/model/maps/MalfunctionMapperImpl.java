package ru.gb.maintenance.model.maps;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.Malfunction;
import ru.gb.maintenance.model.dtos.MalfunctionDto;
import ru.gb.maintenance.services.MaintenanceServiceImpl;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T22:01:40+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MalfunctionMapperImpl implements MalfunctionMapper {

    @Autowired
    private MaintenanceServiceImpl maintenanceServiceImpl;

    @Override
    public List<MalfunctionDto> toDtoS(List<Malfunction> listT) {
        if ( listT == null ) {
            return null;
        }

        List<MalfunctionDto> list = new ArrayList<MalfunctionDto>( listT.size() );
        for ( Malfunction malfunction : listT ) {
            list.add( toDto( malfunction ) );
        }

        return list;
    }

    @Override
    public MalfunctionDto toDto(Malfunction malfunction) {
        if ( malfunction == null ) {
            return null;
        }

        MalfunctionDto malfunctionDto = new MalfunctionDto();

        malfunctionDto.setMaintenanceId( malfunctionMaintenanceId( malfunction ) );
        malfunctionDto.setId( malfunction.getId() );
        malfunctionDto.setName( malfunction.getName() );
        malfunctionDto.setTroubleshooting( malfunction.getTroubleshooting() );
        malfunctionDto.setSpareParts( malfunction.getSpareParts() );

        return malfunctionDto;
    }

    @Override
    public Malfunction toEntity(MalfunctionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Malfunction malfunction = new Malfunction();

        malfunction.setMaintenance( maintenanceServiceImpl.getObjectById( dto.getMaintenanceId() ) );
        malfunction.setId( dto.getId() );
        malfunction.setName( dto.getName() );
        malfunction.setTroubleshooting( dto.getTroubleshooting() );
        malfunction.setSpareParts( dto.getSpareParts() );

        return malfunction;
    }

    private Long malfunctionMaintenanceId(Malfunction malfunction) {
        Maintenance maintenance = malfunction.getMaintenance();
        if ( maintenance == null ) {
            return null;
        }
        return maintenance.getId();
    }
}
