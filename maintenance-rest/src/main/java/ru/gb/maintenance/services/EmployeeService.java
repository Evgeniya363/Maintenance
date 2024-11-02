package ru.gb.maintenance.services;

import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService extends BaseEntityService<Employee, EmployeeDto> {
    List<EmployeeDto> findByPostId(Long id);

    List<EmployeeDto> findByDepartmentId(Long id);
}
