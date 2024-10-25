package ru.gb.maintenance.model;

import lombok.Getter;

@Getter
public enum Type {
    // Назначено, Выполнено, Отложено, Возобоновлено
    //Scheduled, Completed, Postponed, Resumed
    SCHEDULED("Назначено", 1),
    INWORKS("В работе", 2),
    COMPLETED("Завершено", 3),
    POSTPONED("Отложено", 4),
    RESUMED("Возобоновлено", 5);

    private String name;
    private int id;

    Type(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
