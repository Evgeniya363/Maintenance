package ru.gb.maintenance.model.map;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dto.EmployeeDto;
import ru.gb.maintenance.service.DepartmentServiceImpl;
import ru.gb.maintenance.service.PostServiceImpl;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T12:23:44+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;
    @Autowired
    private PostServiceImpl postServiceImpl;

    @Override
    public List<EmployeeDto> toDtoS(List<Employee> listT) {
        if ( listT == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( listT.size() );
        for ( Employee employee : listT ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setDepartmentId( entityDepartmentId( entity ) );
        employeeDto.setPostId( entityPostId( entity ) );
        employeeDto.setId( entity.getId() );
        employeeDto.setFirstName( entity.getFirstName() );
        employeeDto.setPatronymic( entity.getPatronymic() );
        employeeDto.setSecondName( entity.getSecondName() );

        return employeeDto;
    }

    @Override
    public Employee toEntity(EmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setDepartment( departmentServiceImpl.getObjectById( dto.getDepartmentId() ) );
        employee.setPost( postServiceImpl.getObjectById( dto.getPostId() ) );
        employee.setId( dto.getId() );
        employee.setFirstName( dto.getFirstName() );
        employee.setPatronymic( dto.getPatronymic() );
        employee.setSecondName( dto.getSecondName() );

        return employee;
    }

    private Long entityDepartmentId(Employee employee) {
        Department department = employee.getDepartment();
        if ( department == null ) {
            return null;
        }
        return department.getId();
    }

    private Long entityPostId(Employee employee) {
        Post post = employee.getPost();
        if ( post == null ) {
            return null;
        }
        return post.getId();
    }
}
