package ru.gb.maintenance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "malfunction")
public class Malfunction extends SimpleEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //FetchType.LAZY — загружать коллекцию дочерних объектов при первом обращении к ней (вызове get) — так называемая отложенная загрузка.
    /*optional=false Это инструкция во время выполнения. Основная функция, которую она выполняет, связана с отложенной загрузкой. Вы не сможете выполнить отложенную загрузку сущности, не относящейся к коллекции, если не установите для параметра optional значение false (поскольку Hibernate не знает, должен ли там быть прокси-сервер или значение null, если только вы не укажете, что значение null невозможно, чтобы он мог сгенерировать прокси-сервер).*/
    @JoinColumn(name =  "maintenance_id")
//    @JsonIgnore
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
