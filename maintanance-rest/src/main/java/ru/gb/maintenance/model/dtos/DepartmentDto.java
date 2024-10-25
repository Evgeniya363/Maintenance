package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DepartmentDto extends BaseDto {

    private String name;

    @JsonProperty("company_id")
    Long companyId;

}
