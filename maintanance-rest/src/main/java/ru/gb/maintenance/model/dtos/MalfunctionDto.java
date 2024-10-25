package ru.gb.maintenance.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MalfunctionDto extends BaseDto {
    private String name;
    private String troubleshooting;
    String spareParts;
}
