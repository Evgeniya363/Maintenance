package ru.gb.maintenance.services;

import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dtos.DepartmentDto;

import java.util.List;

public interface DepartmentService extends BaseEntityService<Department, DepartmentDto> {
    List<DepartmentDto> findByCompanyId(Long id);
}
