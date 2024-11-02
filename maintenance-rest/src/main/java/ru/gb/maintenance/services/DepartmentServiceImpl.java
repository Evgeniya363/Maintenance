package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.model.maps.DepartmentMapper;
import ru.gb.maintenance.repositories.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseEntityServiceImpl<Department, DepartmentDto, DepartmentMapper> implements DepartmentService{
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper mapper) {
        super(departmentRepository, mapper);
        this.repository = departmentRepository;
    }

    @GetMapping
    @Override
    public List<DepartmentDto> findByCompanyId(Long id) {
        return mapper.toDtoList(repository.findByCompanyId(id));
    }
}
