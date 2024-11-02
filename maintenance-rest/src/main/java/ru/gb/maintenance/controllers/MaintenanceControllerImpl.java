package ru.gb.maintenance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.repositories.criteria.MaintenanceCriteria;
import ru.gb.maintenance.services.MaintenanceService;
import ru.gb.maintenance.services.MaintenanceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceControllerImpl extends BaseEntityControllerImpl<Maintenance, MaintenanceDto> {
    private final MaintenanceService service;
    public MaintenanceControllerImpl(MaintenanceServiceImpl service) {
        super(service);
        this.service = service;
    }


    /* GET  http://localhost:8080/maintenances/search local port
            http://localhost:8081/maintenances/search containers port

    {   // "Maintenance search criteria in the request body"
        "company_id": 105
        // , "equipment_id": 129
        // , "contractor_id": 127
        // , "department_id": 107
        // , "model_id": 115
        // , "manufacturer_id": 111
        , "equipment_id": 130
        , "categories_id": 127
        , "begin_date": "01.01.2023"
        , "end_date": "31.12.2023"
    }
    */
    @GetMapping("/search")
    public ResponseEntity<List<MaintenanceDto>> findByCriteria(@RequestBody MaintenanceCriteria criteria) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.toDtoList(service.findByCriteria(criteria)));
    }
}
