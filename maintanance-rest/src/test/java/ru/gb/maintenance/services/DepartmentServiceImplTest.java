package ru.gb.maintenance.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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