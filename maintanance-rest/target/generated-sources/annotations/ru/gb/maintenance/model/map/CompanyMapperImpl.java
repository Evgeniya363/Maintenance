package ru.gb.maintenance.model.map;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dto.CompanyDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T12:23:44+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDto toDto(Company t) {
        if ( t == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setId( t.getId() );
        companyDto.setName( t.getName() );

        return companyDto;
    }

    @Override
    public Company toEntity(CompanyDto d) {
        if ( d == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( d.getId() );
        company.setName( d.getName() );

        return company;
    }

    @Override
    public List<CompanyDto> toDtoS(List<Company> listT) {
        if ( listT == null ) {
            return null;
        }

        List<CompanyDto> list = new ArrayList<CompanyDto>( listT.size() );
        for ( Company company : listT ) {
            list.add( toDto( company ) );
        }

        return list;
    }
}
