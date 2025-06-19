package com.danceSchool.api.salaEquipamento;

import com.danceSchool.api.equipamento.Equipamento;
import com.danceSchool.api.sala.Sala;
import com.danceSchool.api.salaEquipamentoId.SalaEquipamentoId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sala_equipamento")
public class SalaEquipamento {
    @EmbeddedId
    private SalaEquipamentoId id;

    @MapsId("idEquipamento")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipamento", nullable = false)
    private Equipamento idEquipamento;

    @MapsId("idSala")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala idSala;

    @Column(name = "quantidade")
    private Integer quantidade;

}