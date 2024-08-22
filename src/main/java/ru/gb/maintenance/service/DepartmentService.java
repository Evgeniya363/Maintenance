package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.repositiry.DepartmentRepository;

@Service
public class DepartmentService extends EntityService<Department, DepartmentRepository> {
    public DepartmentService(DepartmentRepository repository) {
        super(repository);
    }
}
