package ru.gb.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.map.BaseMapper;
import ru.gb.maintenance.model.map.DepartmentMapper;
import ru.gb.maintenance.service.BaseEntityServiceImpl;
import ru.gb.maintenance.service.DepartmentServiceImpl;

@RestController
    @RequestMapping("/departments")
    public class DepartmentControllerImpl extends BaseEntityControllerImpl<Department, DepartmentDto> {
        public DepartmentControllerImpl(DepartmentServiceImpl service) {
            super(service);
        }
    }
