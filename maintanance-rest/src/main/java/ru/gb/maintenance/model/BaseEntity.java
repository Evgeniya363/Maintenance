package ru.gb.maintenance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

//    protected String name;

    @CreationTimestamp
    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonProperty("modify_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime modifyAt;

// TODO проверить заполнение полей автоматически
//    public BaseEntity() {
//        this.createdAt = LocalDateTime.now();
//        this.modifyAt = LocalDateTime.now();
//    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }


}