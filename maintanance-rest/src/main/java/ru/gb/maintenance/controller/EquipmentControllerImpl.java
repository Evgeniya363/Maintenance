package ru.gb.maintenance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.service.BaseEntityService;
import ru.gb.maintenance.service.EquipmentService;

@RestController
@RequestMapping("/equipments")
public class EquipmentControllerImpl extends  BaseEntityControllerImpl<Equipment, EquipmentDto> {
    public EquipmentControllerImpl(EquipmentService service) {
        super(service);
    }

}
