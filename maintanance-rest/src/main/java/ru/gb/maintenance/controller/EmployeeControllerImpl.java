package ru.gb.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dto.EmployeeDto;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.service.EmployeeService;
import ru.gb.maintenance.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControllerImpl extends BaseEntityControllerImpl<Employee, EmployeeDto> {
    @Autowired
    EquipmentService equipmentService;

    public EmployeeControllerImpl(EmployeeService service) {
        super(service);
    }

    @GetMapping("/{id}/equipment")
    public ResponseEntity<List<EquipmentDto>> findEquipmentsByEmployeeId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByEmployeeId(id));
    }


}
