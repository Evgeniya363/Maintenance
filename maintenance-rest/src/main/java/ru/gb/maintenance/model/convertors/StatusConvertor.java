package ru.gb.maintenance.model.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.gb.maintenance.model.Status;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConvertor implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getId();
    }

    @Override
    public Status convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;

        }

        return Stream.of(Status.values())
                .filter(c -> c.getId() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
