package com.danceSchool.api.entity.turmaSala;

import com.danceSchool.api.entity.sala.Sala;
import com.danceSchool.api.entity.turma.Turma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turma_sala")
public class TurmaSala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public TurmaSala(DataTurmaSala data) {
        this.id = data.id();
        if (data.idTurmaId() != null) {
            this.idTurma = new Turma();
            this.idTurma.setId(data.idTurmaId());
        }
        if (data.idSalaId() != null) {
            this.idSala = new Sala();
            this.idSala.setNumero(data.idSalaId());
        }
        this.inicioLocacao = data.inicioLocacao();
        this.fimLocacao = data.fimLocacao();
    }

}