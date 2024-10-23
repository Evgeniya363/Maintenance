package ru.gb.maintenance.model.dto;

import lombok.Data;
import ru.gb.maintenance.model.criteria.Requestable;

@Data
public abstract class BaseDto implements HasId, Requestable {
    protected Long id;
};
