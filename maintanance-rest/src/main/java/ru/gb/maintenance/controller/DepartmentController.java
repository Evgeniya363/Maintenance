package ru.gb.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.repositiry.CompanyRepository;
import ru.gb.maintenance.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController extends EntityController<Department, DepartmentService> {
    public DepartmentController(DepartmentService service) {
        super(service);
    }

}
