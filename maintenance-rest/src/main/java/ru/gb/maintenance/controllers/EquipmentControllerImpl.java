package ru.gb.maintenance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.repositories.EquipmentRepository;
import ru.gb.maintenance.repositories.criteria.EquipmentCriteria;
import ru.gb.maintenance.services.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentControllerImpl extends  BaseEntityControllerImpl<Equipment, EquipmentDto> {

    private final EquipmentService service;

    public EquipmentControllerImpl(EquipmentService service) {
        super(service);
        this.service = service;
    }

    /* GET http://localhost:8080/maintenances/search
        containers port: 8081
    {  // "Equipment search criteria in the request body"
       "company_id": 105
        , "equipment_id": 129
        , "department_id": 108
        // , "model_id": 117
        // , "manufacturer_id": 111
        , "categories_id": 127
        , "begin_date": "01.01.2023"
        , "end_date": "31.12.2023"

    }
    */
    @GetMapping("/search")
    public ResponseEntity<List<EquipmentDto>> findByCriteria(@RequestBody EquipmentCriteria parameters) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.toDtoList(service.findByCriteria(parameters)));
    }
}
