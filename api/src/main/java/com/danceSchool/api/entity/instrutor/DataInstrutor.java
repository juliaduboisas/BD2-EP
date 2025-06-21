package com.danceSchool.api.entity.instrutor;

public record DataInstrutor(
        String cpf,
        String funcionarioCpf // Representing the foreign key for Funcionario
) {
    public DataInstrutor(Instrutor instrutor) {
        this(
                instrutor.getCpf(),
                instrutor.getFuncionario().getCpf()
        );
    }
}
