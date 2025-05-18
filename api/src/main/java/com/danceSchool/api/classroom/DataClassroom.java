package com.danceSchool.api.classroom;

import com.danceSchool.api.enums.Gender;
import com.danceSchool.api.enums.Nivel;

import java.time.LocalTime;

public record DataClassroom(Integer id, Integer qtdAulasSemanais, LocalTime horarioInicio, LocalTime horarioFim, Integer tamanho, Gender genero, Nivel nivel, Integer idModalidade, String cpfInstrutor) {
    public DataClassroom(Classroom classroom){
        this(classroom.getId(), classroom.getQtdAulasSemanais(), classroom.getHorarioInicio(), classroom.getHorarioFim(), classroom.getTamanho(), classroom.getGenero(), classroom.getNivel(), classroom.getIdModalidade(), classroom.getCpfInstrutor());
    }
}
