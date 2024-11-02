package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.services.CompanyServiceImpl;


@Mapper(config = MappingConfiguration.class, uses = {CompanyServiceImpl.class})
public interface DepartmentMapper extends BaseMapper<Department, DepartmentDto> {
    @Mapping(source = "company.id", target = "companyId")
    DepartmentDto toDto(Department department);

    @Mapping(source = "companyId", target = "company")
    Department toEntity(DepartmentDto dto);

    // Пример:
//    @Mapper(componentModel = "spring", uses = { PersonService.class })
//    public interface SchoolMapper extends EntityMapper<SchoolDTO, School>{
//
//        @Mapping(source = "personId", target = "person")
//        School toEntity(SchoolDTO schoolDTO);
//    }

}
