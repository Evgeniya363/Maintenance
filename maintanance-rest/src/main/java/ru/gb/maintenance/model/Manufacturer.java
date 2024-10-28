package ru.gb.maintenance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "manufacturer")
public class Manufacturer extends SimpleEntity {
    @Column(nullable = false)
    private String name;
}
