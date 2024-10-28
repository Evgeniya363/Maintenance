package ru.gb.maintenance.model.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.gb.maintenance.model.criteria.Requestable;

@Getter
@Setter
public abstract class BaseDto implements HasId, Requestable {
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;
};
