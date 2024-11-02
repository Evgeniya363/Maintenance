package ru.gb.maintenance.model;

import lombok.Getter;

@Getter
public enum Status {
    SCHEDULED("Назначено", 0),
    INWORKS("В работе", 1),
    COMPLETED("Выполнено", 2),
    REJECTED("Отклонено", 3),
    POSTPONED("Отложено", 4);

    private String name;
    private int id;

    Status(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
