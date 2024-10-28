package ru.gb.maintenance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.gb.maintenance.model.dtos.HasId;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
// позволяет вынести общие поля в родительский класс, но при этом не создавать для него отдельную таблицу
public abstract class BaseEntity implements HasId {
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonProperty("modify_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime modifyAt;

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }


}