package com.danceSchool.api.student;

import java.time.LocalDate;

public record DataStudent(String cpf, String nome, Gender genero, LocalDate dataNasc, String email) {
    public DataStudent(Student student){
        this(student.getCpf(), student.getNome(), student.getGenero(), student.getDataNasc(), student.getEmail());
    }
}
