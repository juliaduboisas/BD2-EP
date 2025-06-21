package com.danceSchool.api.entity.campeonato;

import com.danceSchool.api.enums.Nivel;

import java.util.Date;

public record DataCampeonato(Integer id,
                             Date data,
                             Integer salaId,
                             Nivel categoria,
                             String premiacao,
                             Double valorPremiacao,
                             String status
) {
    public DataCampeonato (Campeonato campeonato) {
        this(
                campeonato.getId(),
                campeonato.getData(),
                campeonato.getSala().getNumero(),
                campeonato.getCategoria(),
                campeonato.getPremiacao(),
                campeonato.getValorPremiacao(),
                campeonato.getStatus()
        );
    }
}
