package ru.gb.maintenance.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Malfunction;
import ru.gb.maintenance.model.dtos.MalfunctionDto;
import ru.gb.maintenance.services.BaseEntityService;
import ru.gb.maintenance.services.MalfunctionService;

@RestController
@RequestMapping("/malfunctions")
public class MalfunctionControllerImpl extends BaseEntityControllerImpl<Malfunction, MalfunctionDto> {
    public MalfunctionControllerImpl(MalfunctionService service) {
        super(service);
    }
}
