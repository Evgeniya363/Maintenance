package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.repositiry.CompanyRepository;

@Service
public class CompanyService extends EntityService<Company, CompanyRepository> {
    final private CompanyRepository companyRepository;
    public CompanyService(CompanyRepository repository, CompanyRepository companyRepository) {
        super(repository);
        this.companyRepository = companyRepository;
    }

}
