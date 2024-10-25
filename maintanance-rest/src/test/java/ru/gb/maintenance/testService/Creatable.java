package ru.gb.maintenance.testService;


import org.springframework.test.context.ActiveProfiles;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;

import java.util.List;

@ActiveProfiles("test")
public interface Creatable<T extends BaseEntity, D extends BaseDto> {
    T create();
    D createDto();

    D createDto(T t);

    List<D> createListDto();

    T applySettings(T t);

    D applyDtoSettings(T t, D d);

}
