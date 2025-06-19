package com.danceSchool.api.transacaoSaida;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transacao_saida")
public class TransacaoSaida {
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
    @Column(name = "receptor", length = 70)
    private String receptor;

    @Column(name = "id_nota_fiscal", length = Integer.MAX_VALUE)
    private String idNotaFiscal;

}