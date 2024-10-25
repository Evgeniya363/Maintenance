package ru.gb.maintenance.testService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dtos.CompanyDto;
import ru.gb.maintenance.model.maps.CompanyMapper;
import ru.gb.maintenance.model.maps.CompanyMapperImpl;

@ActiveProfiles("test")
@Service
public class CompanyTestDataCreator extends BaseTestDataCreator<Company, CompanyDto, CompanyMapper> {

    @Autowired
    CompanyMapperImpl mapper;
}
