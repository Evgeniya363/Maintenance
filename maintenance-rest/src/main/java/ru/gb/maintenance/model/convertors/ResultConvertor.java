package ru.gb.maintenance.model.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.gb.maintenance.model.Result;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ResultConvertor implements AttributeConverter<Result, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Result result) {
        if (result == null) {
            return null;
        }
        return result.getId();
    }

    @Override
    public Result convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;

        }

        return Stream.of(Result.values())
                .filter(c -> c.getId() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
