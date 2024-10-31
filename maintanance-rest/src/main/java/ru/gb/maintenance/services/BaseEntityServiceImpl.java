package ru.gb.maintenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;
import ru.gb.maintenance.model.maps.BaseMapper;
import ru.gb.maintenance.repositories.BaseEntityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//@Service
public abstract class BaseEntityServiceImpl<T extends BaseEntity, D extends BaseDto, M extends BaseMapper<T, D>> implements BaseEntityService<T, D> {

    private final BaseEntityRepository<T> repository;
    protected final M mapper;

    @Autowired
    public BaseEntityServiceImpl(BaseEntityRepository<T> baseEntityRepository, M mapper) {
        this.repository = baseEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public T getObjectById(Long entityId) {
        if (entityId == null) return null;
        return repository.findById(entityId).orElseThrow(() -> new IllegalArgumentException("Id not found: " + entityId));
    }

    @Override
    @Transactional
    public T save(D dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(Long entityId) {
        return repository.findById(entityId);
    }

    @Override
    @Transactional
    public T updateById(D dto, Long id) throws NoSuchElementException {

        repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID [" + id + "] is missing!"));
        dto.setId(id);

        return repository.save(mapper.toEntity(dto));

    }

    @Override
    public void deleteById(Long entityId) {
        repository.deleteById(entityId);
    }

    @Override
    public D toDto(T t) {
        return mapper.toDto(t);
    }

    @Override
    public List<D> toDtoList(List<T> tList) {
        return tList.stream().map(mapper::toDto).toList();
    }
}
