package ru.gb.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.dto.EmployeeDto;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.service.DepartmentServiceImpl;
import ru.gb.maintenance.service.EmployeeService;
import ru.gb.maintenance.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentControllerImpl extends BaseEntityControllerImpl<Department, DepartmentDto> {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EquipmentService equipmentService;

    public DepartmentControllerImpl(DepartmentServiceImpl service) {
        super(service);
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<List<EmployeeDto>> findEmployeesByDepartmentId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findByDepartmentId(id));
    }

    @GetMapping("/{id}/equipments")
    public ResponseEntity<List<EquipmentDto>> findEquipmentByDepartmentId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByDepartmentId(id));
    }

}
