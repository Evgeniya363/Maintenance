package ru.gb.maintenance.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@EqualsAndHashCode(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleEntity extends BaseEntity {
    protected String name;
}
