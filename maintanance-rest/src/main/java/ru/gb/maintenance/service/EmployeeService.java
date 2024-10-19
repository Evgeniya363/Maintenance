package ru.gb.maintenance.service;

import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends BaseEntityService<Employee, EmployeeDto> {
    List<EmployeeDto> findByPostId(Long id);

//    Optional<EmployeeDto> findByEquipmentId(Long id);

    List<EmployeeDto> findByDepartmentId(Long id);
}
