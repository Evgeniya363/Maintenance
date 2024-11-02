package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dtos.CompanyDto;
import ru.gb.maintenance.model.maps.CompanyMapper;
import ru.gb.maintenance.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl extends BaseEntityServiceImpl<Company, CompanyDto, CompanyMapper> implements CompanyService {

    public CompanyServiceImpl(CompanyRepository repository, CompanyMapper mapper, CompanyRepository companyRepository) {
        super(repository, mapper);
    }


}
