package ru.gb.maintenance.model;

import lombok.Getter;

@Getter
public enum Result {
    INPROGRESS("В обработке", 0),
    DONE("Завершено", 1);

    private String name;
    private int id;

    Result(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
