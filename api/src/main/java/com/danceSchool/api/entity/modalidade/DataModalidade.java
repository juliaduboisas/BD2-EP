package com.danceSchool.api.entity.modalidade;

public record DataModalidade(Integer id, String nome) {
    public DataModalidade(Modalidade modalidade){ this(modalidade.getId(), modalidade.getNome());}
}
