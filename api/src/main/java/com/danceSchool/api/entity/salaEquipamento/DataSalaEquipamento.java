package com.danceSchool.api.entity.salaEquipamento;

public record DataSalaEquipamento(
        Integer idEquipamento,
        Integer idSala,
        Integer quantidade
) {

    public DataSalaEquipamento(SalaEquipamento salaEquipamento) {
        this(
            salaEquipamento.getIdEquipamento().getId(),
            salaEquipamento.getIdSala().getNumero(),
            salaEquipamento.getQuantidade()
        );
    }
}
