package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
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

//    @Column(name =  "is_planned")
//    @Enumerated(EnumType.ORDINAL)

    @Column(name = "service_type")
    private Type serviceType;  // Плановая, внеплановая: Enum

    @Column(name = "service_state")
    private Status serviceState;  // Назначено, Выполнено, Отложено, Возобоновлено: Enum

    private String reason;  // Причина: Enum

    private String malfunction;  // Неисправность

    private String troubleshooting;  //  Устранение неисправности

    @Column(name = "spare_parts")  // запчасти
    private String spareParts;

//    @Transient
//    @OneToMany(
//            mappedBy = "maintenance",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true  // orphanRemoval = true — это параметр в аннотации @OneToMany, который используется для того, чтобы не оставалось дочерних сущностей без родительских.
//    )
//    List<Malfunction> malfunctions;  // Неисправности
//
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
