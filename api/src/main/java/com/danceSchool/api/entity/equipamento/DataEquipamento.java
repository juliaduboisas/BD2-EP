package com.danceSchool.api.entity.equipamento;

public record DataEquipamento(
        Integer id,
        String tipo
) {
     DataEquipamento(Equipamento equipamento) {
        this(
                equipamento.getId(),
                equipamento.getTipo()
        );
    }
}
