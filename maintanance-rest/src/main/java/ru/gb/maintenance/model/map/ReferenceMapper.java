package ru.gb.maintenance.model.map;

//import io.micrometer.common.lang.NonNull;
import lombok.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import javax.enterprise.context.ApplicationScoped;

//@Component
@ApplicationScoped
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @ObjectFactory
    public <T> T map(@NonNull final Long id, @TargetType Class<T> type) {

        return entityManager.getReference(type, id);
    }
}
