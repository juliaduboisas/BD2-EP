package com.danceSchool.api.classroom;

import com.danceSchool.api.enums.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    List<Classroom> findAllByIdModalidade(Integer idModalidade);
    List<Classroom> findAllByCpfInstrutor(String cpfInstrutor);
    List<Classroom> findAllByNivel(Nivel nivel);
}
