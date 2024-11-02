package ru.gb.maintenance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dtos.CompanyDto;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.services.CompanyServiceImpl;
import ru.gb.maintenance.services.DepartmentService;
import ru.gb.maintenance.services.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyControllerImpl extends BaseEntityControllerImpl<Company, CompanyDto>{

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EquipmentService equipmentService;

    public CompanyControllerImpl(CompanyServiceImpl service) {
        super(service);
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<List<DepartmentDto>> findDepartmentByCompanyId(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findByCompanyId(id));
    }

    @GetMapping("/{id}/equipments")
    public ResponseEntity<List<EquipmentDto>> findEmployeesByCompanyId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByCompanyId(id));
    }
}
