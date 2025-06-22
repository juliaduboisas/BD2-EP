package com.danceSchool.api.entity.matricula;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DataMatricula(
        Integer id,
        LocalDate dataMatricula,
        BigDecimal valor,
        String cpfAluno,
        Integer idTransacaoId,
        Integer idTurmaId
) {
    public DataMatricula(Matricula matricula) {
        this(
                matricula.getId(),
                matricula.getDataMatricula(),
                matricula.getValor(),
                matricula.getCpfAluno().getCpf(),
                matricula.getIdTransacao().getId(),
                matricula.getIdTurma().getId()
        );
    }
}
