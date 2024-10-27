package ru.gb.maintenance.model.maps;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.services.EquipmentServiceImpl;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T22:55:09+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MaintenanceMapperImpl implements MaintenanceMapper {

    @Autowired
    private EquipmentServiceImpl equipmentServiceImpl;

    @Override
    public List<MaintenanceDto> toDtoS(List<Maintenance> listT) {
        if ( listT == null ) {
            return null;
        }

        List<MaintenanceDto> list = new ArrayList<MaintenanceDto>( listT.size() );
        for ( Maintenance maintenance : listT ) {
            list.add( toDto( maintenance ) );
        }

        return list;
    }

    @Override
    public MaintenanceDto toDto(Maintenance entity) {
        if ( entity == null ) {
            return null;
        }

        MaintenanceDto maintenanceDto = new MaintenanceDto();

        maintenanceDto.setEquipmentId( entityEquipmentId( entity ) );
        maintenanceDto.setId( entity.getId() );
        maintenanceDto.setDate( entity.getDate() );
        maintenanceDto.setType( entity.getType() );
        maintenanceDto.setStatus( entity.getStatus() );
        maintenanceDto.setResult( entity.getResult() );
        maintenanceDto.setReason( entity.getReason() );

        return maintenanceDto;
    }

    @Override
    public Maintenance toEntity(MaintenanceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Maintenance maintenance = new Maintenance();

        maintenance.setEquipment( equipmentServiceImpl.getObjectById( dto.getEquipmentId() ) );
        maintenance.setId( dto.getId() );
        maintenance.setDate( dto.getDate() );
        maintenance.setType( dto.getType() );
        maintenance.setStatus( dto.getStatus() );
        maintenance.setResult( dto.getResult() );
        maintenance.setReason( dto.getReason() );

        return maintenance;
    }

    private Long entityEquipmentId(Maintenance maintenance) {
        Equipment equipment = maintenance.getEquipment();
        if ( equipment == null ) {
            return null;
        }
        return equipment.getId();
    }
}
