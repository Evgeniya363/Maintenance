package ru.gb.maintenance.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManufacturerDto extends BaseDto {
    private String name;
}
