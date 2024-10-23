package ru.gb.maintenance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.model.criteria.EquipmentCriteria;
import ru.gb.maintenance.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentControllerImpl extends  BaseEntityControllerImpl<Equipment, EquipmentDto> { // implements BaseQueryController<EquipmentDto, EquipmentParameters>{

    final EquipmentService equipmentService;

    public EquipmentControllerImpl(EquipmentService service, EquipmentService equipmentService) {
        super(service);
        this.equipmentService = equipmentService;
    }

//    @GetMapping("/find-items")
//    ResponseEntity<List<EquipmentDto>> findByCriteria (@RequestBody EquipmentDto criteria) {
//        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByCriteria(criteria));
//    }

//    @Override
    @GetMapping("/search")
    public ResponseEntity<List<EquipmentDto>> findByCriteria(@RequestBody EquipmentCriteria parameters) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByCriteria(parameters));
    }
}
