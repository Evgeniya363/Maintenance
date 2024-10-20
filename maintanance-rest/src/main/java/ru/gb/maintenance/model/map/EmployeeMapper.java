package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.dto.EmployeeDto;
import ru.gb.maintenance.service.CompanyServiceImpl;
import ru.gb.maintenance.service.DepartmentServiceImpl;
import ru.gb.maintenance.service.PostServiceImpl;

@Mapper(config = MappingConfiguration.class, uses = {DepartmentServiceImpl.class, PostServiceImpl.class})
public interface EmployeeMapper extends  BaseMapper<Employee, EmployeeDto> {

//    @Mapping(source = "patronymic", target = "patronymic") // без него отчество не заполняется
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "post.id", target = "postId")
    EmployeeDto toDto(Employee entity);



//    @Mapping(source = "patronymic", target = "patronymic") // без него отчество не заполняется
    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "postId", target = "post")
    Employee toEntity(EmployeeDto dto);

}
