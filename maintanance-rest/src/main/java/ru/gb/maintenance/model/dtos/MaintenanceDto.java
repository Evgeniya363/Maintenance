package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.gb.maintenance.model.Result;
import ru.gb.maintenance.model.Status;
import ru.gb.maintenance.model.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class MaintenanceDto extends BaseDto{

//    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern="dd.MM.yyyy")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate date;

    @JsonProperty("equipment_id")
    private Long equipmentId;

    @JsonProperty("contractor_id")
    private Long contractorId;

    @JsonProperty("type_id")
    private Type type;

    @JsonProperty("status_id")
    private Status status;

    @JsonProperty("result_id")
    private Result result;

    private String reason;

}
