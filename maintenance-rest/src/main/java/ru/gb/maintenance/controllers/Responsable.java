package ru.gb.maintenance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Responsable<T> {
    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(Long id);

    ResponseEntity<T> create(T t);

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<T> update(Long id, T t);


}
