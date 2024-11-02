package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "model")
public class Model extends SimpleEntity {

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

}
