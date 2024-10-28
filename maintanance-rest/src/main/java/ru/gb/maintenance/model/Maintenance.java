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

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id")
    private Employee contractor;  // Подрядчик

    private Type type;  // Плановая, внеплановая

    private Status status;  // Назначено, Выполнено, Не выполнено, Отложено

    @Transient
    @Column(name = "result")
    private Result result() {
        return status.equals(Status.COMPLETED) || status.equals(Status.REJECTED) ?
                Result.DONE :
                Result.INPROGRESS;
    }

    ;  // В обработке, Завершено

    private String reason;  // Причина

//    @Transient
//    @OneToMany(
//            mappedBy = "maintenance",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true  // orphanRemoval = true — это параметр в аннотации @OneToMany, который используется для того, чтобы не оставалось дочерних сущностей без родительских.
//    )
//    @JsonIgnore
//    @JoinColumn(name = "maintenance_id")
//
//    List<Malfunction> malfunctions;  // Неисправности

//    public void addMalfunction(Malfunction malfunction) {
//        malfunctions.add(malfunction);
//        malfunction.setMaintenance(this);
//    }
//
//    public void removeMalfunction(Malfunction malfunction) {
//        malfunctions.remove(malfunction);
//        malfunction.setMaintenance(null);
//    }


}
