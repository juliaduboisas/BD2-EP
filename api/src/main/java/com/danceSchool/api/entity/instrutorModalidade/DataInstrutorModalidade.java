package com.danceSchool.api.entity.instrutorModalidade;

public record DataInstrutorModalidade(
        String cpfInstrutor,
        Integer idModalidade,
        Integer nivelCapacitacao
) {
    DataInstrutorModalidade(InstrutorModalidade instrutorModalidade) {
        this(
                instrutorModalidade.getCpfInstrutor().getCpf(),
                instrutorModalidade.getIdModalidade().getId(),
                instrutorModalidade.getNivelCapacitacao()
        );
    }
}
