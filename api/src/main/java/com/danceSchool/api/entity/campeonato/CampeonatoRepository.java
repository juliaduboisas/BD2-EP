package com.danceSchool.api.entity.campeonato;

import com.danceSchool.api.enums.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CampeonatoRepository extends JpaRepository<Campeonato,Integer> {
    List<Campeonato> findByData(Date data);
    List<Campeonato> findByCategoria(Nivel categoria);
}