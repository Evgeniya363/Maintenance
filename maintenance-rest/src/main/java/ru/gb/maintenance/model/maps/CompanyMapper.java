package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;

import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dtos.CompanyDto;

@Mapper(config = MappingConfiguration.class)
public interface CompanyMapper extends BaseMapper<Company, CompanyDto> {

//    CompanyDto toDto(Company company);

}