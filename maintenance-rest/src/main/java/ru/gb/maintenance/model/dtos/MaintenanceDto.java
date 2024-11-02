package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.gb.maintenance.model.Status;
import ru.gb.maintenance.model.Type;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class MaintenanceDto extends BaseDto{

    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate date;

    @JsonProperty("equipment_id")
    private Long equipmentId;

    @JsonProperty("contractor_id")
    private Long contractorId;

    @JsonProperty("type_id")
    private Type type;

    @JsonProperty("status_id")
    private Status status;

    private String reason;

}
