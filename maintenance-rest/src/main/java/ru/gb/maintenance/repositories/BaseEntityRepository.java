package ru.gb.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.gb.maintenance.model.BaseEntity;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
