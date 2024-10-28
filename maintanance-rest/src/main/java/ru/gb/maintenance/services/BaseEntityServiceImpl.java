package ru.gb.maintenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;
import ru.gb.maintenance.model.maps.BaseMapper;
import ru.gb.maintenance.repositories.BaseEntityRepository;

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

        repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID [" + id + "] is missing!"));
        dto.setId(id);

        return mapper.toDto(repository.save(mapper.toEntity(dto)));

    }

    @Override

    public void deleteById(Long entityId) {
        repository.deleteById(entityId);
    }

    @Override
    public T getObjectById(Long entityId) {
        if (entityId == null)
            return null;
        return repository.findById(entityId).orElseThrow(() ->  new IllegalArgumentException("Id not found: " + entityId));
    }
}
