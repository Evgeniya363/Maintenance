package ru.gb.maintenance.testService;

import ru.gb.maintenance.model.SimpleEntity;
import ru.gb.maintenance.model.dtos.BaseDto;
import ru.gb.maintenance.model.maps.BaseMapper;

public abstract class SimpleCreatorTest<T extends SimpleEntity, D extends BaseDto, M extends BaseMapper<T,D>> extends BaseCreatorTest<T, D, M> {
//    @Override
//    public T create() {
//        T t = getInstanceOfT();
//        t.setName(t.getClass().getSimpleName() + "#" + random.nextInt(1, 10));
//        return repository.save(t);
//    }

    @Override
    public T applySettings(T t) {
        t.setName(t.getClass().getSimpleName() + "#" + random.nextInt(1, 10));
        return super.applySettings(t);
    }
}
