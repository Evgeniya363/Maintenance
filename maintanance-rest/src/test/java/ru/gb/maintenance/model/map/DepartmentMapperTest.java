package ru.gb.maintenance.model.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



//@ActiveProfiles("test")
//@SpringBootTest
class DepartmentMapperTest { //} extends BaseEntityController<Department, DepartmentService<Department, DepartmentRepository>> {

//    final DepartmentMapper departmentMapper = new DepartmentMapperImpl();
//    ThreadLocalRandom random = ThreadLocalRandom.current();
//
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//    @Autowired
//    CompanyRepository companyRepository;
//
//    @Bean
//    ReferenceMapper referenceMapper() {
//        return new ReferenceMapper();
//    };
//
//    @BeforeEach
//    void deleteAllData() {
//        departmentRepository.deleteAll();
//        companyRepository.deleteAll();
//    }
//
//
//    @Test
//    void toDto() {
//        //given company&department
//        Company company = new Company();
//        company.setName("Company1");
//        Department department = new Department();
//        department.setName("Department1");
//        department.setCompany(company);
//
//        // when calling departmentMapper::toDto
//        DepartmentDto departmentDto = departmentMapper.toDto(department);
//
//        // then a new DeliveryAddress is created, based on the given company&department
//        assertEquals(departmentDto.getName(), department.getName());
//        assertEquals(departmentDto.getId(), department.getId());
//        assertEquals(departmentDto.getCompanyId(), company.getId());
//
//    }
//
//    @Test
//    void toEntity() {
//        // given
//        Company expectedCompany = createCompany();
//        Department expectedDepartment = createDepartment(expectedCompany);
//        DepartmentDto expectedDepartmentDto = createDepartmentDto(expectedCompany, expectedDepartment);
//
//        System.out.println(expectedDepartmentDto);
//
//        // when
//        Department actual = departmentMapper.toEntity(expectedDepartmentDto);
//
//        // then
//        assertEquals(actual.getId(), expectedDepartment.getId());
//        assertEquals(actual.getName(), expectedDepartment.getName());
////        assertEquals(actual.getCompany(), expectedCompany);
//    }
//
//    private Company createCompany() {
//
//        Company company = new Company();
//        company.setName("Company#" + random.nextLong(1, 100L));
//
//        return companyRepository.save(company);
//    }
//
//    private Department createDepartment(Company company) {
//
//        Department department = new Department();
//        department.setName("Department#" + random.nextLong(1, 100L));
//        department.setCompany(company);
//
//        return departmentRepository.save(department);
//    }
//
//    private DepartmentDto createDepartmentDto(Company company, Department department) {
//        DepartmentDto departmentDto = new DepartmentDto();
//        departmentDto.setName(department.getName());
//        departmentDto.setId(department.getId());
//        departmentDto.setCompanyId(company.getId());
//
//        return departmentDto;
//    }


}