package ru.gb.maintenance.testService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.map.DepartmentMapper;
import ru.gb.maintenance.repositiry.CompanyRepository;

@ActiveProfiles("test")
@Service
public class DepartmentTestDataCreator extends BaseTestDataCreator<Department, DepartmentDto, DepartmentMapper> {
    @Autowired
    DepartmentMapper mapper;
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyTestDataCreator companyCreator;

    @Override
    public Department applySettings(Department department) {
        long companyCount = companyRepository.count();
        if (companyCount == 0) {
            companyCount = random.nextLong(1, 10);
            for (int i = 0; i < companyCount; i++) {
                companyCreator.create();
            }
        }
        department.setCompany(companyRepository.findAll().get(random.nextInt(0, Math.toIntExact(companyCount))));
        return department;
    }

    @Override
    public DepartmentDto applyDtoSettings(Department department, DepartmentDto departmentDto) {
        departmentDto.setCompanyName(department.getCompany().getName());
        return departmentDto;
    }
}
