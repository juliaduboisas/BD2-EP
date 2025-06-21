package com.danceSchool.api.entity.salaEquipamento;

import com.danceSchool.api.entity.equipamento.Equipamento;
import com.danceSchool.api.entity.sala.Sala;
import com.danceSchool.api.entity.id.SalaEquipamentoId;
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