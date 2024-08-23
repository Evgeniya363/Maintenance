package ru.gb.maintenance.service;

import java.util.List;
import java.util.Optional;

public interface CrudOperable<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T create(T t);

    void delete(Long id);

    T update(Long id, T t);

    void checkForValidity(T t);

}
