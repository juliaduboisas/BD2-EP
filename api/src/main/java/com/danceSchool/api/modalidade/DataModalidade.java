package com.danceSchool.api.modalidade;

public record DataModalidade(Integer id, String nome) {
    public DataModalidade(Modalidade modalidade){ this(modalidade.getId(), modalidade.getNome());}
}
