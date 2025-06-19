package com.danceSchool.api.salaModalidadeId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SalaModalidadeId implements Serializable {
    @Serial
    private static final long serialVersionUID = -7847763584011370940L;

    @NotNull
    @Column(name = "id_sala", nullable = false)
    private Integer idSala;

    @NotNull
    @Column(name = "id_modalidade", nullable = false)
    private Integer idModalidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SalaModalidadeId entity = (SalaModalidadeId) o;
        return Objects.equals(this.idSala, entity.idSala) &&
                Objects.equals(this.idModalidade, entity.idModalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSala, idModalidade);
    }

}