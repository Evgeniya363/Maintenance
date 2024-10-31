package ru.gb.maintenance.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@EqualsAndHashCode(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class SimpleEntity extends BaseEntity {
    @Column(nullable = false)
    protected String name;
}
