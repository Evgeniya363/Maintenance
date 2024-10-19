package ru.gb.maintenance.repositiry;

import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends BaseEntityRepository<Employee> {
    List<Employee> findByPostId(Long id);

}
