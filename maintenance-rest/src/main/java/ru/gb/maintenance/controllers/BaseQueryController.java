package ru.gb.maintenance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseQueryController<D, P> {
    ResponseEntity<List<D>> findByCriteria (@RequestBody P parameters);
}
