package ru.gb.maintenance.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.repositiry.CompanyRepository;
import ru.gb.maintenance.repositiry.DepartmentRepository;
import ru.gb.maintenance.testService.DepartmentTestDataCreator;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class TempDepartmentServiceImplTest {

    @Autowired
    DepartmentTestDataCreator departmentCreator;

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
        Department department = departmentCreator.create();
        DepartmentDto expected = departmentCreator.createDto(department);

        // when
        Optional<DepartmentDto> actual = departmentService.findById(department.getId());

        // then
        assertTrue(actual.isPresent());
        assertEquals(actual.get(), expected);

    }

}