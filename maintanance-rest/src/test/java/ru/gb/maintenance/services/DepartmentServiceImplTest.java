package ru.gb.maintenance.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.repositories.DepartmentRepository;
import ru.gb.maintenance.testService.DepartmentCreatorTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    DepartmentCreatorTest departmentCreator;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

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
        Department expected = departmentCreator.create();

        // when
        Optional<Department> actual = departmentService.findById(expected.getId());

        // then
        assertTrue(actual.isPresent());
        assertEquals(actual.get(), expected);

    }

}