package ru.gb.maintenance.model.map;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.service.CompanyServiceImpl;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T12:23:44+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Autowired
    private CompanyServiceImpl companyServiceImpl;

    @Override
    public List<DepartmentDto> toDtoS(List<Department> listT) {
        if ( listT == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( listT.size() );
        for ( Department department : listT ) {
            list.add( toDto( department ) );
        }

        return list;
    }

    @Override
    public DepartmentDto toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setCompanyId( departmentCompanyId( department ) );
        departmentDto.setId( department.getId() );
        departmentDto.setName( department.getName() );

        return departmentDto;
    }

    @Override
    public Department toEntity(DepartmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Department department = new Department();

        department.setCompany( companyServiceImpl.getObjectById( dto.getCompanyId() ) );
        department.setId( dto.getId() );
        department.setName( dto.getName() );

        return department;
    }

    private Long departmentCompanyId(Department department) {
        Company company = department.getCompany();
        if ( company == null ) {
            return null;
        }
        return company.getId();
    }
}
