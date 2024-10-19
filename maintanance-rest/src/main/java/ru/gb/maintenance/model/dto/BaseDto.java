package ru.gb.maintenance.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class BaseDto implements HasId {

    protected Long id;

    protected String name;

};
