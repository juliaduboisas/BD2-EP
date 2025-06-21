package com.danceSchool.api.entity.turmaSala;

import java.time.LocalDate;

public record DataTurmaSala(
        Integer id,
        Integer idTurmaId, // Represents the ID from Turma
        Integer idSalaId,  // Represents the ID from Sala
        LocalDate inicioLocacao,
        LocalDate fimLocacao
) {

    public DataTurmaSala(TurmaSala turmaSala) {
        this(
            turmaSala.getId(),
            turmaSala.getIdTurma().getId(),
            turmaSala.getIdSala().getNumero(),
            turmaSala.getInicioLocacao(),
            turmaSala.getFimLocacao()
        );
    }
}