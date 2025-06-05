package com.danceSchool.api.turma;

import com.danceSchool.api.enums.Gender;
import com.danceSchool.api.enums.Nivel;

import java.time.LocalTime;

public record DataTurma(Integer id, Integer qtdAulasSemanais, LocalTime horarioInicio, LocalTime horarioFim, Integer tamanho, Gender genero, Nivel nivel, Integer idModalidade, String cpfInstrutor) {
    public DataTurma(Turma turma){
        this(turma.getId(), turma.getQtdAulasSemanais(), turma.getHorarioInicio(), turma.getHorarioFim(), turma.getTamanho(), turma.getGenero(), turma.getNivel(), turma.getIdModalidade(), turma.getCpfInstrutor());
    }
}
