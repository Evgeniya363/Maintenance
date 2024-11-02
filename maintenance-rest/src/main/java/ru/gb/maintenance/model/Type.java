package ru.gb.maintenance.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Type {
    PLANNED("Плановая", 0),
    UNSCHEDULED("Внеплановая",1);
    private String name;
    private int id;

    Type(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
