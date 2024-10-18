package ru.gb.maintenance.repositiry;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.map.ReferenceMapper;

import java.util.List;

@Repository
public interface DepartmentRepository extends BaseEntityRepository<Department> {
    List<Department> findByCompanyId(Long id);
}
