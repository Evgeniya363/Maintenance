package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.dto.ModelDto;
import ru.gb.maintenance.model.map.DepartmentMapper;
import ru.gb.maintenance.model.map.ModelMapper;
import ru.gb.maintenance.repositiry.DepartmentRepository;
import ru.gb.maintenance.repositiry.ModelRepository;

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
