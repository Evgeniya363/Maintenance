package ru.gb.maintenance.model.maps;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Contractor;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dtos.ContractorDto;
import ru.gb.maintenance.services.EmployeeServiceImpl;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T20:38:51+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ContractorMapperImpl implements ContractorMapper {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Override
    public List<ContractorDto> toDtoList(List<Contractor> listT) {
        if ( listT == null ) {
            return null;
        }

        List<ContractorDto> list = new ArrayList<ContractorDto>( listT.size() );
        for ( Contractor contractor : listT ) {
            list.add( toDto( contractor ) );
        }

        return list;
    }

    @Override
    public ContractorDto toDto(Contractor entity) {
        if ( entity == null ) {
            return null;
        }

        ContractorDto contractorDto = new ContractorDto();

        contractorDto.setEmployeeId( entityEmployeeId( entity ) );
        contractorDto.setId( entity.getId() );

        return contractorDto;
    }

    @Override
    public Contractor toEntity(ContractorDto dto) {
        if ( dto == null ) {
            return null;
        }

        Contractor contractor = new Contractor();

        contractor.setEmployee( employeeServiceImpl.getObjectById( dto.getEmployeeId() ) );
        contractor.setId( dto.getId() );

        return contractor;
    }

    private Long entityEmployeeId(Contractor contractor) {
        Employee employee = contractor.getEmployee();
        if ( employee == null ) {
            return null;
        }
        return employee.getId();
    }
}
