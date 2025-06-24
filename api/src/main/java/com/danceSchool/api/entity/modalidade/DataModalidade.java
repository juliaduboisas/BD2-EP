package com.danceSchool.api.entity.modalidade;

public record DataModalidade(String nome) {
    public DataModalidade(Modalidade modalidade){
        this(
            modalidade.getNome()
        );
    }
}
