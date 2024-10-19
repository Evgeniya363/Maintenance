package ru.gb.maintenance.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.repositiry.CompanyRepository;
import ru.gb.maintenance.repositiry.DepartmentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class DepartmentServiceImplTest {
/*
    @Autowired
    DatabaseUtil databaseUtil;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    CompanyServiceImpl companyService;


    @Test
    void findByIdEmpty() {
        // given
        assertFalse(departmentRepository.existsById(2L));
        // then
        Assertions.assertTrue(departmentService.findById(2L).isEmpty());
    }

    @Test
    void findByIdPresent() {
        // given
        Company expectedCompany = databaseUtil.createCompany();
        Department expectedDepartment = databaseUtil.createDepartment();

        // when
        Optional<DepartmentDto> actualDepartment = departmentService.findById(expectedDepartment.getId());

        // then
        assertTrue(actualDepartment.isPresent());
        assertEquals(actualDepartment.get().getId(), expectedDepartment.getId());
        assertEquals(actualDepartment.get().getName(), expectedDepartment.getName());
        assertEquals(actualDepartment.get().getCompanyId(), expectedCompany.getId());
        assertEquals(actualDepartment.get().getCompanyName(), expectedCompany.getName());

    }

*/
}