package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.map.DepartmentMapper;
import ru.gb.maintenance.repositiry.BaseEntityRepository;
import ru.gb.maintenance.repositiry.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseEntityServiceImpl<Department, DepartmentDto, DepartmentMapper> {
    final DepartmentRepository repository;

    public DepartmentServiceImpl(BaseEntityRepository<Department> baseEntityRepository, DepartmentMapper mapper, DepartmentRepository repository) {
        super(baseEntityRepository, mapper);
        this.repository = repository;
    }

    public List<Department> findByCompanyId(Long entityId) {
        return repository.findByCompanyId(entityId);
    }
}
