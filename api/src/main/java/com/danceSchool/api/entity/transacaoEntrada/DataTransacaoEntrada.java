package com.danceSchool.api.entity.transacaoEntrada;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DataTransacaoEntrada(
        Integer id,
        BigDecimal valor,
        LocalDateTime dataHora,
        String descricao,
        String emissor,
        String idNotaFiscal
) {

    public DataTransacaoEntrada(TransacaoEntrada transacaoEntrada) {
        this(
            transacaoEntrada.getId(),
            transacaoEntrada.getValor(),
            transacaoEntrada.getDataHora(),
            transacaoEntrada.getDescricao(),
            transacaoEntrada.getEmissor(),
            transacaoEntrada.getIdNotaFiscal()
        );
    }
}
