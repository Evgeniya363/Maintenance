package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ModelDto extends BaseDto {

    private String name;

    @JsonProperty("manufacturer_id")
    Long manufacturerId;

}
