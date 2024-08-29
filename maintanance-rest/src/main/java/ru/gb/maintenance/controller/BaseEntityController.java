package ru.gb.maintenance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.map.BaseMapper;

import java.util.List;

@Service
public interface BaseEntityController<T extends BaseEntity, D> {

    public ResponseEntity<List<D>> findAll();

    public ResponseEntity<D> findById(Long id);

    public ResponseEntity<D> create(D object);

    public ResponseEntity<Void> delete(Long id);

    public ResponseEntity<D> update(Long id, D object);

}
