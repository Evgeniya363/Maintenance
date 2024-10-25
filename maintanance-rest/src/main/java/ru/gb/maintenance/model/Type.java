package ru.gb.maintenance.model;

import lombok.Getter;

@Getter
public enum Type {
    // Назначено, Выполнено, Отложено, Возобоновлено
    //Scheduled, Completed, Postponed, Resumed
    SCHEDULED("Назначено", 1),
    COMPLETED("Выполнено", 2),
    POSTPONED("Отложено", 3),
    RESUMED("Возобоновлено", 4);

    private String name;
    private int code;

    Type(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
}
