package ru.gb.maintenance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name ="maintenance")
public class Maintenance extends SimpleEntity {

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Employee contractor;  // Подрядчик

    private Type type;  // Плановая, внеплановая

    private Status status;  // Назначено, Выполнено, Не выполнено, Отложено, Возобоновлено

    private Result result;  // В обработке, Выполнено, Не выполнено

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
