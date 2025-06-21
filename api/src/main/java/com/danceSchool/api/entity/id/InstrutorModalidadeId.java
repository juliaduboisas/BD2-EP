package com.danceSchool.api.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class InstrutorModalidadeId implements Serializable {
    @Serial
    private static final long serialVersionUID = 5969865838755503744L;

    @Size(max = 11)
    @NotNull
    @Column(name = "cpf_instrutor", nullable = false, length = 11)
    private String cpfInstrutor;

    @NotNull
    @Column(name = "id_modalidade", nullable = false)
    private Integer idModalidade;

    public InstrutorModalidadeId(String cpfInstrutor, Integer idModalidade) {
        this.cpfInstrutor = cpfInstrutor;
        this.idModalidade = idModalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InstrutorModalidadeId entity = (InstrutorModalidadeId) o;
        return Objects.equals(this.cpfInstrutor, entity.cpfInstrutor) &&
                Objects.equals(this.idModalidade, entity.idModalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpfInstrutor, idModalidade);
    }

}