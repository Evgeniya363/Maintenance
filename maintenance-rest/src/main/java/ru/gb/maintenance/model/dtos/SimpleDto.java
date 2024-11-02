package ru.gb.maintenance.model.dtos;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleDto extends BaseDto {
    private String name;
}
