package ru.gb.maintenance.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;
import ru.gb.maintenance.services.BaseEntityService;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseEntityControllerImpl<T extends BaseEntity, D extends BaseDto> implements BaseEntityController<T, D> {

    protected final BaseEntityService<T, D> service;

    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.toDtoList(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(post -> ResponseEntity.status(HttpStatus.OK).body(service.toDto(post)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D object) {

        object = service.toDto(service.save(object));
        if (object == null) {
            return ResponseEntity.notFound().build();
        }
//        object = toDoBeforeSaving(object);
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable Long id, @RequestBody D dto) {

        dto = service.toDto(service.updateById(dto, id));
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }

//    @Override
//    public D toDoBeforeSaving(D d) {
//        return d;
//    }
}
