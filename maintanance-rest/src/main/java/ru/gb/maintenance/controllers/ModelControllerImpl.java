package ru.gb.maintenance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.model.dtos.ModelDto;
import ru.gb.maintenance.services.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelControllerImpl extends BaseEntityControllerImpl<Model, ModelDto> {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EquipmentService equipmentService;

    public ModelControllerImpl(ModelServiceImpl service) {
        super(service);
    }

    @GetMapping("/{id}/equipments")
    public ResponseEntity<List<EquipmentDto>> findEquipmentByModelId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByModelId(id));
    }

}
