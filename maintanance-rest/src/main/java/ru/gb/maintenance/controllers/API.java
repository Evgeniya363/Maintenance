package ru.gb.maintenance.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class API {

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Object.class)))
    @interface AccessObjectRequest {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Ресурс создан", responseCode = "201", content = @Content(schema = @Schema(implementation = Object.class)))
    @interface CreateObjectRequest {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Контент отсутствует", responseCode = "204", content = @Content(schema = @Schema(implementation = Void.class)))
    @interface NoContentRequest {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Объект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @interface NotFoundResponse {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = Void.class)))
    @interface InternalFailRequest {

    }


}
