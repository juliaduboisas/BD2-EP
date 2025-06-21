package com.danceSchool.api.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class SalaEquipamentoId implements Serializable {
    @Serial
    private static final long serialVersionUID = 469983553257060653L;

    @NotNull
    @Column(name = "id_equipamento", nullable = false)
    private Integer idEquipamento;

    @NotNull
    @Column(name = "id_sala", nullable = false)
    private Integer idSala;

    public SalaEquipamentoId(Integer idEquipamento, Integer idSala) {
        this.idEquipamento =  idEquipamento;
        this.idSala = idSala;
    }

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