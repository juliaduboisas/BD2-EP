package com.danceSchool.api.entity.transacaoEntrada;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

}