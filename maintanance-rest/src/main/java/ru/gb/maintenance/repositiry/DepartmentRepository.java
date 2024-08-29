package ru.gb.maintenance.repositiry;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Department;

@Repository
public interface DepartmentRepository extends BaseEntityRepository<Department> {
}
