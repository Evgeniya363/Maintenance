package ru.gb.maintenance.model.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.gb.maintenance.repositories.criteria.Requestable;

@Data
public abstract class BaseDto implements HasId {
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;
};
