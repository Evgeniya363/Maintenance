package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dtos.EmployeeDto;
import ru.gb.maintenance.services.DepartmentServiceImpl;
import ru.gb.maintenance.services.PostServiceImpl;

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
