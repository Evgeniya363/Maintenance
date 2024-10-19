package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dto.EmployeeDto;

@Mapper(config = MappingConfiguration.class)
public interface EmployeeMapper extends  BaseMapper<Employee, EmployeeDto> {

}
