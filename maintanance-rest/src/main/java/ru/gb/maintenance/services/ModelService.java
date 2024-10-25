package ru.gb.maintenance.services;

import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dtos.ModelDto;

import java.util.List;

public interface ModelService extends BaseEntityService<Model, ModelDto> {
    List<ModelDto> findByManufacturerId(Long id);
}
