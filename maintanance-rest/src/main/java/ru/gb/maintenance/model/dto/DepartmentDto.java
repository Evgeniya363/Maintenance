package ru.gb.maintenance.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@EqualsAndHashCode(callSuper = true)
@Data
public class DepartmentDto implements BaseDto {

    private Long id;

    private String name;

    @JsonProperty("company_id")
    Long companyId;

    @JsonProperty("company_name")
    String companyName;
}
