package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;

import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.CompanyDto;
import ru.gb.maintenance.model.dto.DepartmentDto;

@Mapper(config = MappingConfiguration.class)
public interface CompanyMapper extends BaseMapper<Company, CompanyDto> {

//    CompanyDto toDto(Company company);

}