package com.danceSchool.api.salaEquipamentoId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SalaEquipamentoId implements Serializable {
    private static final long serialVersionUID = 469983553257060653L;
    @NotNull
    @Column(name = "id_equipamento", nullable = false)
    private Integer idEquipamento;

    @NotNull
    @Column(name = "id_sala", nullable = false)
    private Integer idSala;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SalaEquipamentoId entity = (SalaEquipamentoId) o;
        return Objects.equals(this.idEquipamento, entity.idEquipamento) &&
                Objects.equals(this.idSala, entity.idSala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento, idSala);
    }

}