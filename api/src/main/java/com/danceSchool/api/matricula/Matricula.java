package com.danceSchool.api.matricula;

import com.danceSchool.api.aluno.Aluno;
import com.danceSchool.api.transacaoEntrada.TransacaoEntrada;
import com.danceSchool.api.turma.Turma;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_aluno")
    private Aluno cpfAluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transacao")
    private TransacaoEntrada idTransacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Turma idTurma;

}