package ru.gb.maintenance.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryDto extends BaseDto {
    private String name;
}
