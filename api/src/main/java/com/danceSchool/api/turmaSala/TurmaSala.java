package com.danceSchool.api.turmaSala;

import com.danceSchool.api.sala.Sala;
import com.danceSchool.api.turma.Turma;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "turma_sala")
public class TurmaSala {
    @Id
    @Column(name = "id_locacao", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Turma idTurma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala idSala;

    @Column(name = "inicio_locacao")
    private LocalDate inicioLocacao;

    @Column(name = "fim_locacao")
    private LocalDate fimLocacao;

}