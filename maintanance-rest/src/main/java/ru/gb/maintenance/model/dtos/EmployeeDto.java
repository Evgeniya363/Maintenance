package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDto extends BaseDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("patronymic") // оставила, т.к. влияет на порядок полей в ответе
    private String patronymic;

    @JsonProperty("second_name")
    private String secondName;

    @JsonProperty("department_id")
    private Long departmentId;

    @JsonProperty("post_id")
    private Long postId;

}
