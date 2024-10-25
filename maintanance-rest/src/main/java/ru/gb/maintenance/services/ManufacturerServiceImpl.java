package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.dtos.ManufacturerDto;
import ru.gb.maintenance.model.maps.ManufacturerMapper;
import ru.gb.maintenance.repositories.ManufacturerRepository;


@Service
public class ManufacturerServiceImpl extends BaseEntityServiceImpl<Manufacturer, ManufacturerDto, ManufacturerMapper> implements ManufacturerService {

    public ManufacturerServiceImpl(ManufacturerRepository repository, ManufacturerMapper mapper) {
        super(repository, mapper);
    }
}
