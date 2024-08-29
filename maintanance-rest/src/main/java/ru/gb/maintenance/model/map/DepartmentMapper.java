package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.service.CompanyServiceImpl;


@Mapper(config = MappingConfiguration.class, uses = {CompanyServiceImpl.class})
public interface DepartmentMapper extends BaseMapper<Department, DepartmentDto> {
    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.name", target = "companyName")
    DepartmentDto toDto(Department department);

//    @Mapper(componentModel = "spring", uses = { PersonService.class })
//    public interface SchoolMapper extends EntityMapper<SchoolDTO, School>{
//
//        @Mapping(source = "personId", target = "person")
//        School toEntity(SchoolDTO schoolDTO);
//    }
    @Mapping(source = "companyId", target = "company")
    Department toEntity(DepartmentDto dto);
}
