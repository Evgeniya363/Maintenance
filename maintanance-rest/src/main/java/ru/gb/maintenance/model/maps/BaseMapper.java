package ru.gb.maintenance.model.maps;

import java.util.List;


public interface BaseMapper <T, D> {
    D toDto(T t);
    T toEntity(D d);
    List<D> toDtoS(List<T> listT);
}
