package com.danceSchool.api.entity.matricula;

import com.danceSchool.api.entity.aluno.Aluno;
import com.danceSchool.api.entity.transacaoEntrada.TransacaoEntrada;
import com.danceSchool.api.entity.turma.Turma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Matricula(DataMatricula data) {
        this.id = data.id();
        this.dataMatricula = data.dataMatricula();
        this.valor = data.valor();
        if (data.cpfAluno() != null) {
            this.cpfAluno = new Aluno();
            this.cpfAluno.setCpf(data.cpfAluno());
        }
        if (data.idTransacaoId() != null) {
            this.idTransacao = new TransacaoEntrada();
            this.idTransacao.setId(data.idTransacaoId());
        }
        if (data.idTurmaId() != null) {
            this.idTurma = new Turma();
            this.idTurma.setId(data.idTurmaId());
        }
    }

}