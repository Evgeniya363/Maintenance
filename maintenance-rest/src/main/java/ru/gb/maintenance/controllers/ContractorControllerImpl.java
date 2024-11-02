package ru.gb.maintenance.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Contractor;
import ru.gb.maintenance.model.dtos.ContractorDto;
import ru.gb.maintenance.services.ContractorService;

@RestController
@RequestMapping("/contractors")
public class ContractorControllerImpl extends BaseEntityControllerImpl<Contractor, ContractorDto>{
    public ContractorControllerImpl(ContractorService service) {
        super(service);
    }

}
