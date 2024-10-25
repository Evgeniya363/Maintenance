package ru.gb.maintenance.model;

import lombok.Getter;

@Getter
public enum Status {
    PLANNED("Плановая", 1),
    UNSCHEDULED("Внеплановая",2);

    private String name;
    private int code;

    Status(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
}
