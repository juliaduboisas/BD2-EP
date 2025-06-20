package com.danceSchool.api.entity.salaModalidade;

import com.danceSchool.api.entity.modalidade.Modalidade;
import com.danceSchool.api.entity.sala.Sala;
import com.danceSchool.api.entity.salaModalidadeId.SalaModalidadeId;
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