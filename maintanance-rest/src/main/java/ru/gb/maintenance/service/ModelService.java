package ru.gb.maintenance.service;

import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dto.ModelDto;

import java.util.List;

public interface ModelService extends BaseEntityService<Model, ModelDto> {
    List<ModelDto> findByManufacturerId(Long id);
}
