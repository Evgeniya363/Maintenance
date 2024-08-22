package ru.gb.maintenance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.maintenance.model.Identifiable;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class EntityService<T extends Identifiable, R extends JpaRepository<T, Long>> implements CrudOperable<T> {

    private final R repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    ;

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    ;

    public T create(T t) {
        return repository.save(t);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public T update(Long id, T t) throws NoSuchElementException {

        if (!id.equals(t.getId())) throw new InputMismatchException();

        repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID [" + id + "] is missing!"));

        return repository.save(t);

    }
}
