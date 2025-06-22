package com.danceSchool.api.entity.equipamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    List<Equipamento> findByTipoContainingIgnoreCase(String tipo);
}