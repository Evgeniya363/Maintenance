package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.map.DepartmentMapper;
import ru.gb.maintenance.repositiry.BaseEntityRepository;
import ru.gb.maintenance.repositiry.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseEntityServiceImpl<Department, DepartmentDto, DepartmentMapper> implements DepartmentService{
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper mapper, DepartmentRepository repository) {
        super(departmentRepository, mapper);
        this.repository = departmentRepository;
    }

    @GetMapping
    @Override
    public List<DepartmentDto> findByCompanyId(Long id) {
        return mapper.toDtoS(repository.findByCompanyId(id));
    }
}
