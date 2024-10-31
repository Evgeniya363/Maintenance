package ru.gb.maintenance.testService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.model.maps.DepartmentMapper;

@ActiveProfiles("test")
@Service
public class DepartmentCreatorTest extends SimpleCreatorTest<Department, DepartmentDto, DepartmentMapper> {

    @Autowired
    CompanyCreatorTest companyCreator;

    @Override
    public Department applySettings(Department department) {
        department.setCompany(companyCreator.getAny());
        return super.applySettings(department);
    }

}
