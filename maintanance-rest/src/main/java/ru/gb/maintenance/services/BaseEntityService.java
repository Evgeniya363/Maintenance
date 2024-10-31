package ru.gb.maintenance.services;

import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;

import java.util.List;
import java.util.Optional;

public interface BaseEntityService<T extends BaseEntity, D> {

    T getObjectById(Long entityId);

    Optional<T> findById(Long entityId);

    List<T> findAll();

    T save(D entity);

    T updateById(D entity, Long entityId);

    void deleteById(Long entityId);

    D toDto(T t);

    List<D> toDtoList(List<T> list);
}
