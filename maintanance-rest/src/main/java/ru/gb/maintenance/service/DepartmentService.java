package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.repositiry.CompanyRepository;
import ru.gb.maintenance.repositiry.DepartmentRepository;

import java.util.NoSuchElementException;

@Service
public class DepartmentService extends EntityService<Department, DepartmentRepository> {
    final CompanyRepository companyRepository;
    public DepartmentService(DepartmentRepository repository, CompanyRepository companyRepository) {
        super(repository);
        this.companyRepository = companyRepository;
    }

    @Override
    public void checkForValidity(Department department) {

        if (department.getCompany()==null)
            throw new NoSuchElementException("Bad company");

    }

}
