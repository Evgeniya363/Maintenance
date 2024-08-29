package ru.gb.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dto.CompanyDto;
import ru.gb.maintenance.model.map.BaseMapper;
import ru.gb.maintenance.model.map.CompanyMapper;
import ru.gb.maintenance.service.BaseEntityServiceImpl;
import ru.gb.maintenance.service.CompanyServiceImpl;

@RestController
@RequestMapping("/companies")
public class CompanyControllerImpl extends BaseEntityControllerImpl<Company, CompanyDto>{

    public CompanyControllerImpl(CompanyServiceImpl service) {
        super(service);
    }
}
