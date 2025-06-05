package com.danceSchool.api.aluno;

import com.danceSchool.api.enums.Gender;

import java.time.LocalDate;

public record DataAluno(String cpf, String nome, Gender genero, LocalDate dataNasc, String email) {
    public DataAluno(Aluno aluno){
        this(aluno.getCpf(), aluno.getNome(), aluno.getGenero(), aluno.getDataNasc(), aluno.getEmail());
    }
}
