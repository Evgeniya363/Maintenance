package ru.gb.maintenance.service;

import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dto.EquipmentDto;

import java.util.List;
import java.util.Optional;

public interface BaseEntityService<T extends BaseEntity, D> {

    T getObjectById(Long entityId);

    Optional<D> findById(Long entityId);

    List<D> findAll();

    D save(D entity);

    D updateById(D entity, Long entityId);

    void deleteById(Long entityId);

}
