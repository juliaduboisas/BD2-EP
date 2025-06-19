package com.danceSchool.api.salaModalidade;

import com.danceSchool.api.modalidade.Modalidade;
import com.danceSchool.api.sala.Sala;
import com.danceSchool.api.salaModalidadeId.SalaModalidadeId;
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
@Table(name = "sala_modalidade")
public class SalaModalidade {
    @EmbeddedId
    private SalaModalidadeId id;

    @MapsId("idSala")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala idSala;

    @MapsId("idModalidade")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_modalidade", nullable = false)
    private Modalidade idModalidade;

}