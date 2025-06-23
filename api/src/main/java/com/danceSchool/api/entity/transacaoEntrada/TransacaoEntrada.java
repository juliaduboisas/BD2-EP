package com.danceSchool.api.entity.transacaoEntrada;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.danceSchool.api.entity.inscricao.Inscricao;
import com.danceSchool.api.entity.matricula.Matricula;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transacao_entrada")
public class TransacaoEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;

    @Size(max = 70)
    @Column(name = "emissor", length = 70)
    private String emissor;

    @Column(name = "id_nota_fiscal", length = Integer.MAX_VALUE)
    private String idNotaFiscal;

    @OneToMany(mappedBy = "idTransacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inscricao> inscricoes;

    @OneToMany(mappedBy = "idTransacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matricula> matriculas;

    public TransacaoEntrada(DataTransacaoEntrada data) {
        this.id = data.id();
        this.valor = data.valor();
        this.dataHora = data.dataHora();
        this.descricao = data.descricao();
        this.emissor = data.emissor();
        this.idNotaFiscal = data.idNotaFiscal();
    }

}