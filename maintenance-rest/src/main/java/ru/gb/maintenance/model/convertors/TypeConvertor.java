package ru.gb.maintenance.model.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.gb.maintenance.model.Type;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeConvertor implements AttributeConverter<Type, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Type serviceType) {
        if (serviceType == null) {
            return null;
        }
        return serviceType.getId();
    }

    @Override
    public Type convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;

        }

        return Stream.of(Type.values())
                .filter(c -> c.getId() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
