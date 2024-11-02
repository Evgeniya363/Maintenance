package ru.gb.maintenance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;

import java.util.List;

@Service
public interface BaseEntityController<T extends BaseEntity, D extends BaseDto> {

    ResponseEntity<List<D>> findAll();

    ResponseEntity<D> findById(Long id);

    ResponseEntity<D> create(D object);

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<D> update(Long id, D object);

//    D toDoBeforeSaving(D d);

}
