package com.danceSchool.api.entity.instrutorModalidade;

import com.danceSchool.api.entity.instrutor.Instrutor;
import com.danceSchool.api.entity.id.InstrutorModalidadeId;
import com.danceSchool.api.entity.modalidade.Modalidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instrutor_modalidade")
public class InstrutorModalidade {
    @EmbeddedId
    private InstrutorModalidadeId id;

    @MapsId("cpfInstrutor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpf_instrutor", nullable = false)
    private Instrutor cpfInstrutor;

    @MapsId("idModalidade")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_modalidade", nullable = false)
    private Modalidade idModalidade;

    @Column(name = "nivel_capacitacao")
    private Integer nivelCapacitacao;

    public InstrutorModalidade(DataInstrutorModalidade data) {
        this.id = new InstrutorModalidadeId(data.cpfInstrutor(), data.idModalidade());
        this.nivelCapacitacao = data.nivelCapacitacao();
    }

}