package ru.gb.maintenance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dtos.EmployeeDto;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.model.dtos.PostDto;
import ru.gb.maintenance.repositories.criteria.EquipmentCriteria;
import ru.gb.maintenance.repositories.criteria.MaintenanceCriteria;
import ru.gb.maintenance.services.EmployeeService;
import ru.gb.maintenance.services.MaintenanceService;
import ru.gb.maintenance.services.MaintenanceServiceImpl;
import ru.gb.maintenance.services.PostServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceControllerImpl extends BaseEntityControllerImpl<Maintenance, MaintenanceDto> {
    private final MaintenanceService service;
    public MaintenanceControllerImpl(MaintenanceServiceImpl service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<MaintenanceDto>> findByCriteria(@RequestBody MaintenanceCriteria parameters) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.toDtoList(service.findByCriteria(parameters)));
    }
}
