package ru.gb.maintenance.model.maps;

import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;

import java.util.List;


public interface BaseMapper <T extends BaseEntity, D> {
    D toDto(T t);
    T toEntity(D d);
    List<D> toDtoList(List<T> listT);
}
