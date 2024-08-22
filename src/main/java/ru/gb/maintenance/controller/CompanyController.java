package ru.gb.maintenance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.repositiry.CompanyRepository;
import ru.gb.maintenance.service.CompanyService;
import ru.gb.maintenance.service.CrudOperable;

@RestController
@RequestMapping("/companies")
public class CompanyController extends EntityController<Company, CompanyService> {
    public CompanyController(CompanyService service) {
        super(service);
    }
}
