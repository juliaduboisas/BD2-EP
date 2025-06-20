package com.danceSchool.api.entity.inscricao;

import com.danceSchool.api.entity.aluno.Aluno;
import com.danceSchool.api.entity.campeonato.Campeonato;
import com.danceSchool.api.entity.transacaoEntrada.TransacaoEntrada;
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
@Table(name = "inscricao")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_insc", nullable = false)
    private Integer id;

    @Column(name = "taxa", precision = 10, scale = 2)
    private BigDecimal taxa;

    @Column(name = "data_insc")
    private LocalDate dataInsc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transacao")
    private TransacaoEntrada idTransacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_campeonato")
    private Campeonato idCampeonato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_aluno")
    private Aluno cpfAluno;

}