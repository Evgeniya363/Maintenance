package ru.gb.maintenance.model;

import lombok.Getter;

@Getter
public enum Type {
    // Назначено, Выполнено, Отложено, Возобоновлено
    //Scheduled, Completed, Postponed, Resumed
    SCHEDULED("Назначено", 0),
    INWORKS("В работе", 1),
    COMPLETED("Выполнено", 2),
    REJECTED("Отклонено", 3),
    POSTPONED("Отложено", 4),
    RESUMED("Возобоновлено", 5);

    private String name;
    private int id;

    Type(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
