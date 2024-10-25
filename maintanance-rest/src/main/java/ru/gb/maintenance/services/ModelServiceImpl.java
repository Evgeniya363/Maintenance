package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dtos.ModelDto;
import ru.gb.maintenance.model.maps.ModelMapper;
import ru.gb.maintenance.repositories.ModelRepository;

import java.util.List;

@Service
public class ModelServiceImpl extends BaseEntityServiceImpl<Model, ModelDto, ModelMapper> implements ModelService {
    private final ModelRepository repository;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper mapper, ModelRepository repository) {
        super(modelRepository, mapper);
        this.repository = modelRepository;
    }

    @GetMapping
    @Override
    public List<ModelDto> findByManufacturerId(Long id) {
        return mapper.toDtoS(repository.findByManufacturerId(id));
    }
}
