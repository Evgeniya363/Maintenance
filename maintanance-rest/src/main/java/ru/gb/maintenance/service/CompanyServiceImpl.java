package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dto.CompanyDto;
import ru.gb.maintenance.model.map.CompanyMapper;
import ru.gb.maintenance.repositiry.CompanyRepository;

@Service
public class CompanyServiceImpl extends BaseEntityServiceImpl<Company, CompanyDto, CompanyMapper> implements CompanyService {

    public CompanyServiceImpl(CompanyRepository repository, CompanyMapper mapper, CompanyRepository companyRepository) {
        super(repository, mapper);
    }


}
