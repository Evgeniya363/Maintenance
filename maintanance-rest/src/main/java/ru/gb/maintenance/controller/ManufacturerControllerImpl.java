package ru.gb.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dto.EmployeeDto;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.model.dto.ManufacturerDto;
import ru.gb.maintenance.model.dto.PostDto;
import ru.gb.maintenance.service.*;

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
