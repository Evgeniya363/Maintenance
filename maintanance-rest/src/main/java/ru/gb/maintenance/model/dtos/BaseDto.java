package ru.gb.maintenance.model.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.gb.maintenance.model.criteria.Requestable;

@Getter
@Setter
public abstract class BaseDto implements HasId, Requestable {
    protected Long id;
};
