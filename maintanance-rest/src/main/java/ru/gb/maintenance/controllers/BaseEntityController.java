package ru.gb.maintenance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;

import java.util.List;

@Service
public interface BaseEntityController<T extends BaseEntity, D extends BaseDto> {

    public ResponseEntity<List<D>> findAll();

    public ResponseEntity<D> findById(Long id);

    public ResponseEntity<D> create(D object);

    public ResponseEntity<Void> delete(Long id);

    public ResponseEntity<D> update(Long id, D object);

}
