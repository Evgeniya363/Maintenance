package ru.gb.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dto.CompanyDto;
import ru.gb.maintenance.model.map.CompanyMapper;
import ru.gb.maintenance.testService.BaseTestDataCreator;
import ru.gb.maintenance.testService.CompanyTestDataCreator;

@ActiveProfiles("test")
@SpringBootTest
public class CompanyControllerImplTest extends BaseControllerImplTest<Company, CompanyDto, CompanyMapper, BaseTestDataCreator<Company, CompanyDto, CompanyMapper>>{
    @Autowired
     CompanyTestDataCreator creator;

    public CompanyControllerImplTest() {
        uri = "/companies";
    }

}
