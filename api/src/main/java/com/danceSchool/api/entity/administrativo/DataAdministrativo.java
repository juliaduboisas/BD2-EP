package com.danceSchool.api.entity.administrativo;

import com.danceSchool.api.enums.Nivel;
import com.danceSchool.api.entity.funcionario.DataFuncionario;

public record DataAdministrativo(
        String cpf,
        DataFuncionario dataFuncionario, // If you need the Funcionario's CPF
        Nivel nivelAcessos
) {
    public static DataAdministrativo fromEntity(Administrativo administrativo) {
        if (administrativo == null) return null;
        return new DataAdministrativo(
                administrativo.getCpf(),
                new DataFuncionario(administrativo.getFuncionario()),
                administrativo.getNivelAcessos()
        );
    }
}