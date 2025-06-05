package com.danceSchool.api.aluno;

import com.danceSchool.api.enums.Genero;

import java.time.LocalDate;

public record DataAluno(String cpf, String nome, Genero genero, LocalDate dataNasc, String email) {
    public DataAluno(Aluno aluno){
        this(aluno.getCpf(), aluno.getNome(), aluno.getGenero(), aluno.getDataNasc(), aluno.getEmail());
    }
}
