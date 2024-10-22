package ru.gb.maintenance.model.map;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.service.CategoryServiceImpl;
import ru.gb.maintenance.service.DepartmentServiceImpl;
import ru.gb.maintenance.service.EmployeeServiceImpl;
import ru.gb.maintenance.service.ModelService;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T12:23:44+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class EquipmentMapperImpl implements EquipmentMapper {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    @Autowired
    private ModelService modelService;

    @Override
    public List<EquipmentDto> toDtoS(List<Equipment> listT) {
        if ( listT == null ) {
            return null;
        }

        List<EquipmentDto> list = new ArrayList<EquipmentDto>( listT.size() );
        for ( Equipment equipment : listT ) {
            list.add( toDto( equipment ) );
        }

        return list;
    }

    @Override
    public EquipmentDto toDto(Equipment equipment) {
        if ( equipment == null ) {
            return null;
        }

        EquipmentDto equipmentDto = new EquipmentDto();

        equipmentDto.setCategoryId( equipmentCategoryId( equipment ) );
        equipmentDto.setModelId( equipmentModelId( equipment ) );
        equipmentDto.setEmployeeId( equipmentEmployeeId( equipment ) );
        equipmentDto.setDepartmentId( equipmentDepartmentId( equipment ) );
        equipmentDto.setId( equipment.getId() );
        equipmentDto.setSerialNumber( equipment.getSerialNumber() );
        equipmentDto.setInventoryNumber( equipment.getInventoryNumber() );
        equipmentDto.setServiceNumber( equipment.getServiceNumber() );
        equipmentDto.setStartUsageDate( equipment.getStartUsageDate() );
        equipmentDto.setMaintenanceDate( equipment.getMaintenanceDate() );

        return equipmentDto;
    }

    @Override
    public Equipment toEntity(EquipmentDto equipment) {
        if ( equipment == null ) {
            return null;
        }

        Equipment equipment1 = new Equipment();

        equipment1.setCategory( categoryServiceImpl.getObjectById( equipment.getCategoryId() ) );
        equipment1.setModel( modelService.getObjectById( equipment.getModelId() ) );
        equipment1.setEmployee( employeeServiceImpl.getObjectById( equipment.getEmployeeId() ) );
        equipment1.setDepartment( departmentServiceImpl.getObjectById( equipment.getDepartmentId() ) );
        equipment1.setId( equipment.getId() );
        equipment1.setSerialNumber( equipment.getSerialNumber() );
        equipment1.setInventoryNumber( equipment.getInventoryNumber() );
        equipment1.setServiceNumber( equipment.getServiceNumber() );
        equipment1.setStartUsageDate( equipment.getStartUsageDate() );
        equipment1.setMaintenanceDate( equipment.getMaintenanceDate() );

        return equipment1;
    }

    private Long equipmentCategoryId(Equipment equipment) {
        Category category = equipment.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getId();
    }

    private Long equipmentModelId(Equipment equipment) {
        Model model = equipment.getModel();
        if ( model == null ) {
            return null;
        }
        return model.getId();
    }

    private Long equipmentEmployeeId(Equipment equipment) {
        Employee employee = equipment.getEmployee();
        if ( employee == null ) {
            return null;
        }
        return employee.getId();
    }

    private Long equipmentDepartmentId(Equipment equipment) {
        Department department = equipment.getDepartment();
        if ( department == null ) {
            return null;
        }
        return department.getId();
    }
}
