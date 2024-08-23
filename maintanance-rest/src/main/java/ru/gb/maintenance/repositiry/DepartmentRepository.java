package ru.gb.maintenance.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.maintenance.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

