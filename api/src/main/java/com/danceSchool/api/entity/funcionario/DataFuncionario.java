package com.danceSchool.api.entity.funcionario;

import com.danceSchool.api.enums.Genero;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DataFuncionario(String cpf, String nome, Genero genero, LocalDate dataAdmissao, String cargo, BigDecimal salario, String email, String cep, Integer numero, String complemento, String cpfAdm) {
    public DataFuncionario(Funcionario funcionario){
        this(funcionario.getCpf(), funcionario.getNome(), funcionario.getGenero(), funcionario.getDataAdmissao(), funcionario.getCargo(), funcionario.getSalario(), funcionario.getEmail(), funcionario.getCep(), funcionario.getNumero(), funcionario.getComplemento(), funcionario.getCpfAdm().getCpf());
    }
}
