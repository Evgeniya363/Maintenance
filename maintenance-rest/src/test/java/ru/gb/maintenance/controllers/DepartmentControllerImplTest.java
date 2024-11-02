package ru.gb.maintenance.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.model.maps.DepartmentMapper;
import ru.gb.maintenance.testService.DepartmentCreatorTest;


public class DepartmentControllerImplTest extends
        BaseControllerImplTest<Department, DepartmentDto, DepartmentMapper, DepartmentCreatorTest> {
    @Autowired
    DepartmentCreatorTest creator;

    public DepartmentControllerImplTest() {
        super("/departments");
    }
}
