package com.danceSchool.api.turma;

import com.danceSchool.api.enums.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
    List<Turma> findAllByIdModalidade(Integer idModalidade);
    List<Turma> findAllByCpfInstrutor(String cpfInstrutor);
    List<Turma> findAllByNivel(Nivel nivel);
}
