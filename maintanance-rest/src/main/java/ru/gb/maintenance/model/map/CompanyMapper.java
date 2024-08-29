package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.CompanyDto;
import ru.gb.maintenance.model.dto.DepartmentDto;

@Mapper(config = MappingConfiguration.class)
public interface CompanyMapper extends BaseMapper<Company, CompanyDto> {
//        @Mapping(source = "company.id", target = "companyId")

        DepartmentDto toDto(Department department);

//    @Mapping(source = "companyId", target = "company")
//    Department toEntity(DepartmentDto dto);
    }