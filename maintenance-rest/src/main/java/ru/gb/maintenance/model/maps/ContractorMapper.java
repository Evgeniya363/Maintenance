package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Contractor;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dtos.CompanyDto;
import ru.gb.maintenance.model.dtos.ContractorDto;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.services.EmployeeServiceImpl;

@Mapper(config = MappingConfiguration.class,
        uses = EmployeeServiceImpl.class
)
public interface ContractorMapper extends BaseMapper<Contractor, ContractorDto> {
//    @Mapping(source = "employee.id", target = "employeeId")
//    ContractorDto toDto(Contractor entity);
//
////    @Mapping(source = "employeeId", target = "employee")
//    Contractor toEntity(ContractorDto dto);
    @Mapping(source = "employee.id", target = "employeeId")
    ContractorDto toDto(Contractor entity);

    @Mapping(source = "employeeId", target = "employee")
    Contractor toEntity(ContractorDto dto);
}