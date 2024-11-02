package ru.gb.maintenance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.dtos.EquipmentDto;
import ru.gb.maintenance.model.dtos.ManufacturerDto;
import ru.gb.maintenance.services.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerControllerImpl extends BaseEntityControllerImpl<Manufacturer, ManufacturerDto> {

    @Autowired
    EquipmentService equipmentService;

    public ManufacturerControllerImpl(ManufacturerService service) {
        super(service);
    }

    @GetMapping("/{id}/equipments")
    public ResponseEntity<List<EquipmentDto>> findEmployeesByManufacturerId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByManufacturerId(id));
    }
}
