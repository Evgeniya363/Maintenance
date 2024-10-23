package ru.gb.maintenance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.maintenance.model.BaseEntity;

import java.util.List;

public interface BaseQueryController<D, P> {
    ResponseEntity<List<D>> findByCriteria (@RequestBody P parameters);
}
