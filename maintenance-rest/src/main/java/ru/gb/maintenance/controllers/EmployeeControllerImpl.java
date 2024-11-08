package ru.gb.maintenance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dtos.EmployeeDto;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.services.EmployeeService;
import ru.gb.maintenance.services.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControllerImpl extends BaseEntityControllerImpl<Employee, EmployeeDto> {
    @Autowired
    EquipmentService equipmentService;

    public EmployeeControllerImpl(EmployeeService service) {
        super(service);
    }

    @GetMapping("/{id}/equipments")
    public ResponseEntity<List<EquipmentDto>> findEquipmentsByEmployeeId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByEmployeeId(id));
    }

}
