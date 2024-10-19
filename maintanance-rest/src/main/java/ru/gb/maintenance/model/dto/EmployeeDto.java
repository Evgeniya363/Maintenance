package ru.gb.maintenance.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDto extends BaseDto {
    @JsonProperty("full_name")
    String fullName;

}
