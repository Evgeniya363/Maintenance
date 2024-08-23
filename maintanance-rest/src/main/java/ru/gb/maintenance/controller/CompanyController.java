package ru.gb.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController extends EntityController<Company, CompanyService> {
    public CompanyController(CompanyService service) {
        super(service);
    }

}
