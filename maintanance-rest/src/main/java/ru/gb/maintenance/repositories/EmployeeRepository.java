package ru.gb.maintenance.repositories;

import ru.gb.maintenance.model.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseEntityRepository<Employee> {
    List<Employee> findByPostId(Long id);

}
