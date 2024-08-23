package ru.gb.maintenance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.service.CrudOperable;

import java.util.List;

@RequiredArgsConstructor
public abstract class EntityController<T, S extends CrudOperable<T>> implements Responsable<T> {

    private final S service;

    @Override
    @GetMapping
    public ResponseEntity<List<T>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(post -> ResponseEntity.status(HttpStatus.OK).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @Override
    @PostMapping
    public ResponseEntity<T> create(@RequestBody T object) {

        object = service.create(object);
        if (object == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T object) {

        object = service.update(id, object);
        if (object == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(object);

    }

}
