package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "maintenance")
public class Maintenance extends BaseEntity {

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;  // Подрядчик

    private Type type;  // Плановая, внеплановая

    private Status status;  // Назначено, Выполнено, Отклонено, Отложено

    @Transient
    @Column(name = "result")
    private Result result() {
        return status.equals(Status.COMPLETED) || status.equals(Status.REJECTED) ?
                Result.DONE :
                Result.INPROGRESS;
    }

    // В обработке, Завершено

    private String reason;  // Причина


}
