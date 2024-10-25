package ru.gb.maintenance.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends BaseEntityRepository<Department> {
    List<Department> findByCompanyId(Long id);
}
