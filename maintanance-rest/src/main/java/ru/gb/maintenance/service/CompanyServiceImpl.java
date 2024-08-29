package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dto.CompanyDto;
import ru.gb.maintenance.model.map.CompanyMapper;
import ru.gb.maintenance.repositiry.BaseEntityRepository;
import ru.gb.maintenance.repositiry.CompanyRepository;

@Service
public class CompanyServiceImpl extends BaseEntityServiceImpl<Company, CompanyDto, CompanyMapper> {
    final CompanyRepository companyRepository;

    public CompanyServiceImpl(BaseEntityRepository<Company> baseEntityRepository, CompanyMapper mapper, CompanyRepository companyRepository) {
        super(baseEntityRepository, mapper);
        this.companyRepository = companyRepository;
    }

}
