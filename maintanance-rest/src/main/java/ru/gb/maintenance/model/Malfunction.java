package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "malfunction")
public class Malfunction extends SimpleEntity {

    @ManyToOne(fetch = FetchType.LAZY)  //FetchType.LAZY — загружать коллекцию дочерних объектов при первом обращении к ней (вызове get) — так называемая отложенная загрузка.
    private Maintenance maintenance;

    private String troubleshooting;  //  Устранение неисправности

    @Column(name = "spare_parts")  // запчасти
    private String spareParts;

    //Constructors, getters and setters removed for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Malfunction )) return false;
        return id != null && id.equals(((Malfunction) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
