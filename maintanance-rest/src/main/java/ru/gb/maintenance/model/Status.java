package ru.gb.maintenance.model;

import lombok.Getter;

@Getter
public enum Status {
    PLANNED("Плановая", 1),
    UNSCHEDULED("Внеплановая",2);

    private String name;
    private int id;

    Status(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
