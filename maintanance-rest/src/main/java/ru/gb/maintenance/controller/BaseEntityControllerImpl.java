package ru.gb.maintenance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.map.BaseMapper;
import ru.gb.maintenance.service.BaseEntityService;
import ru.gb.maintenance.service.BaseEntityServiceImpl;

import java.util.List;

@RequiredArgsConstructor
public class BaseEntityControllerImpl<T extends BaseEntity, D> implements BaseEntityController<T, D> {

    private final BaseEntityService<T,D> service;
//    private final M mapper;

//    @Override
    @GetMapping
    public ResponseEntity<List<D>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

//    @Override
    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(post -> ResponseEntity.status(HttpStatus.OK).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

//    @Override
    @PostMapping
    public ResponseEntity<D> create(@RequestBody D object) {

        object = service.save(object);
        if (object == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable Long id, @RequestBody D dto) {

        dto = service.updateById(dto, id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);


    }
}
