package ru.gb.maintenance.service;

import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService extends BaseEntityService<Department, DepartmentDto> {
    List<DepartmentDto> findByCompanyId(Long id);
}
