package ru.gb.maintenance.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class SimpleEntity extends BaseEntity {
    protected String name;
}
