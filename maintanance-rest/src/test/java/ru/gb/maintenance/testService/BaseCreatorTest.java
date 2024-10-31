package ru.gb.maintenance.testService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;
import ru.gb.maintenance.model.maps.BaseMapper;
import ru.gb.maintenance.repositories.BaseEntityRepository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ActiveProfiles("test")
public abstract class BaseCreatorTest<T extends BaseEntity, D extends BaseDto, M extends BaseMapper<T, D>> implements CreatableTest<T, D> {

    protected ThreadLocalRandom random = ThreadLocalRandom.current();

    private final ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();

    @Autowired
    M mapper;

    @Autowired
    BaseEntityRepository<T> repository;

    @Override
    @Transactional
    public T create() {
        T t = getInstanceOfT();
        t = applySettings(t);
        return repository.save(t);
    }

    T getInstanceOfT() {
        Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public T applySettings(T t) {
        return t;
    }

    @Override
    public D applyDtoSettings(T t, D d) {
        return d;
    }

    @Override
    public D createDto() {
        D d = getInstanceOfD();
        return mapper.toDto(create());
    }

    @Override
    public D createDto(T t) {
        return mapper.toDto(t);
    }

    D getInstanceOfD() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<D> type = (Class<D>) superClass.getActualTypeArguments()[1];
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<D> createListDto() {
        return createList().stream().map(this::createDto).toList();
    }

    @Override
    public List<T> createList() {
        List<T> list = new ArrayList<>();
        for (int i = 1; i < random.nextInt(1, 10); i++) {
            list.add(create());
        }
        return list;
    }

    @Override
    @Transactional
    public T getAny() {
        if(repository.count() == 0)
            createList();
        long id = ThreadLocalRandom.current().nextLong(1, repository.count() + 1);
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Error find any item from " + getClass()));

    }
}
