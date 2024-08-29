package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;

import java.util.List;


public interface BaseMapper <T, D> {
    D toDto(T t);
    T toEntity(D d);
    List<D> toDtoS(List<T> listT);
}
