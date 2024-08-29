package ru.gb.maintenance.model.dto;

import lombok.Data;

@Data
public class CompanyDto implements BaseDto {
    private Long id;

    private String name;
}
