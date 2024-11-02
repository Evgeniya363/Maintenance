package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.Status;
import ru.gb.maintenance.model.Type;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContractorDto extends BaseDto {

    @JsonProperty("employee_id")
    Long employeeId;

}
