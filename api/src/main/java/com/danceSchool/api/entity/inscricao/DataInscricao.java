package com.danceSchool.api.entity.inscricao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DataInscricao(
        Integer id,
        BigDecimal taxa,
        LocalDate dataInsc,
        Integer idTransacaoId, // Assuming TransacaoEntrada has an Integer ID
        Integer idCampeonatoId, // Assuming Campeonato has an Integer ID
        String cpfAluno          // Assuming Aluno has a String CPF as ID
) {
    public DataInscricao(Inscricao inscricao) {
        this(
                inscricao.getId(),
                inscricao.getTaxa(),
                inscricao.getDataInsc(),
                inscricao.getIdTransacao().getId(),
                inscricao.getIdCampeonato().getId(),
                inscricao.getCpfAluno().getCpf()
        );
    }
}