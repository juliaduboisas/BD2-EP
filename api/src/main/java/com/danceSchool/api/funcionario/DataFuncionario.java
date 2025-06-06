package com.danceSchool.api.funcionario;

import com.danceSchool.api.enums.Genero;

import java.time.LocalDate;

public record DataFuncionario(String cpf, String nome, Genero genero, LocalDate dataAdmissao, String cargo, Double salario, String email, String cep, Integer numero, String complemento, String cpfAdm) {
    public DataFuncionario(Funcionario funcionario){
        this(funcionario.getCpf(), funcionario.getNome(), funcionario.getGenero(), funcionario.getDataAdmissao(), funcionario.getCargo(), funcionario.getSalario(), funcionario.getEmail(), funcionario.getCep(), funcionario.getNumero(), funcionario.getComplemento(), funcionario.getCpfAdm());
    }
}
