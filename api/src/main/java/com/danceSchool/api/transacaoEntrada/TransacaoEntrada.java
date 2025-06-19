package com.danceSchool.api.transacaoEntrada;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "transacao_entrada")
public class TransacaoEntrada {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_hora")
    private Instant dataHora;

    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;

    @Size(max = 70)
    @Column(name = "emissor", length = 70)
    private String emissor;

    @Column(name = "id_nota_fiscal", length = Integer.MAX_VALUE)
    private String idNotaFiscal;

}