package com.danceSchool.api.entity.administrativo;

import com.danceSchool.api.entity.funcionario.DataFuncionario;

public record DataAdministrativo(
        String cpf,
        DataFuncionario dataFuncionario, // If you need the Funcionario's CPF
        Integer nivelAcessos
) {
    public DataAdministrativo(Administrativo administrativo) {
        this(
            administrativo.getCpf(),
            administrativo.getFuncionario() != null ? new DataFuncionario(administrativo.getFuncionario()) : null,
            administrativo.getNivelAcessos()
        );
    }
}