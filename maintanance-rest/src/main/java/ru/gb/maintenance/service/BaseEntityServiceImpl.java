package ru.gb.maintenance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dto.BaseDto;
import ru.gb.maintenance.model.map.BaseMapper;
import ru.gb.maintenance.repositiry.BaseEntityRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//@Service
public abstract class BaseEntityServiceImpl<T extends BaseEntity, D extends BaseDto, M extends BaseMapper<T,D>> implements BaseEntityService<T, D>{

    private final BaseEntityRepository<T> repository;
    protected final M mapper;

    @Autowired
    public BaseEntityServiceImpl(BaseEntityRepository<T> baseEntityRepository, M mapper) {
        this.repository = baseEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public D save(D dto) {
//        System.out.println("1--------------------" + dto);
//        System.out.println("2--------------------" + mapper.toEntity(dto));

        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<D> findAll() {
        return mapper.toDtoS(repository.findAll());
    }

    @Override
    public Optional<D> findById(Long entityId) {
        return repository.findById(entityId).map(mapper::toDto);
    }

    public D updateById(D dto, Long id) throws NoSuchElementException {

        //if (!id.equals(dto.getId())) throw new InputMismatchException();
        repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID [" + id + "] is missing!"));
        dto.setId(id);
//        T entity = mapper.toEntity(dto);
//        entity.setId(id);
//        T save = repository.save(entity);
//        D dto1 = mapper.toDto(save);
//        return dto1;

        return mapper.toDto(repository.save(mapper.toEntity(dto)));

    }

    @Override
    public void deleteById(Long entityId) {
        repository.deleteById(entityId);
    }

    @Override
    public T getObjectById(Long entityId) {
        return repository.findById(entityId).orElseThrow(() ->  new IllegalArgumentException("Id not found: " + entityId));
    }
}
