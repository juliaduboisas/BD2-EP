package com.danceSchool.api.entity.transacaoSaida;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DataTransacaoSaida(
        Integer id,
        BigDecimal valor,
        LocalDateTime dataHora,
        String descricao,
        String receptor,
        String idNotaFiscal
) {

    public DataTransacaoSaida(TransacaoSaida transacaoSaida) {
        this(
            transacaoSaida.getId(),
            transacaoSaida.getValor(),
            transacaoSaida.getDataHora(),
            transacaoSaida.getDescricao(),
            transacaoSaida.getReceptor(),
            transacaoSaida.getIdNotaFiscal()
        );
    }
}

