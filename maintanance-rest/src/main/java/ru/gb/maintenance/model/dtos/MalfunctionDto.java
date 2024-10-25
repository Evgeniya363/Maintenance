package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MalfunctionDto extends BaseDto {

    @JsonProperty("maintenance_id")
    private Long maintenanceId;

    private String name;

    private String troubleshooting;

    @JsonProperty("spare_parts")
    String spareParts;
}
