package com.danceSchool.api.entity.administrativo;

import com.danceSchool.api.enums.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministrativoRepository extends JpaRepository<Administrativo, String> {
    List<Administrativo> findByNivelAcessos(Integer nivel);
}