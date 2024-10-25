package ru.gb.maintenance.controllers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Тип возвращаемого ответа")
public class ExceptionResponse {

  @Schema(description = "Текст ошибки")
  private String reason;

}
