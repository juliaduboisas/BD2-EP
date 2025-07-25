package com.danceSchool.api.entity.salaModalidade;

public record DataSalaModalidade(
        Integer idSala,
        Integer idModalidade
) {

    public DataSalaModalidade(SalaModalidade salaModalidade) {
        this(
            salaModalidade.getIdSala().getNumero(),
            salaModalidade.getIdModalidade().getId()
        );
    }
}
