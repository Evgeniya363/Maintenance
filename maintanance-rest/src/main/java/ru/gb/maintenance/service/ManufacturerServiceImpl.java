package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Manufacturer;
import ru.gb.maintenance.model.dto.ManufacturerDto;
import ru.gb.maintenance.model.map.ManufacturerMapper;
import ru.gb.maintenance.repositiry.ManufacturerRepository;


@Service
public class ManufacturerServiceImpl extends BaseEntityServiceImpl<Manufacturer, ManufacturerDto, ManufacturerMapper> implements ManufacturerService {

    public ManufacturerServiceImpl(ManufacturerRepository repository, ManufacturerMapper mapper) {
        super(repository, mapper);
    }
}
