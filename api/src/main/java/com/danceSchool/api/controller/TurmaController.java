package com.danceSchool.api.controller;

import com.danceSchool.api.entity.turma.Turma;
import com.danceSchool.api.entity.turma.TurmaRepository;
import com.danceSchool.api.entity.turma.DataTurma;
import com.danceSchool.api.enums.Nivel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class TurmaController {
    @Autowired
    TurmaRepository turmaRepository;

    @PostMapping("/add")
    public void addClassroom(@RequestBody DataTurma dataTurma) {
        Turma turma = new Turma(dataTurma);
        turmaRepository.save(turma);
    }

    @GetMapping
    public List<DataTurma> getAllClassrooms() {
        return turmaRepository.findAll()
                .stream()
                .map(DataTurma::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DataTurma getClassroomById(@PathVariable Integer id) {
        return turmaRepository.findById(id).map(DataTurma::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/modality/{idModalidade}")
    public List<DataTurma> getClassroomByModality(@PathVariable Integer idModalidade) {
        return turmaRepository.findAllByIdModalidade(idModalidade)
                .stream()
                .map(DataTurma::new)
                .toList();
    }

    @GetMapping("/instructor/{cpfInstrutor}")
    public List<DataTurma> getClassroomByInstructor(@PathVariable String cpfInstrutor) {
        return turmaRepository.findAllByCpfInstrutor(cpfInstrutor)
                .stream()
                .map(DataTurma::new)
                .toList();
    }

    @GetMapping("/level/{level}")
    public List<DataTurma> getClassroomByLevel(@PathVariable Nivel level) {
        return turmaRepository.findAllByNivel(level)
                .stream()
                .map(DataTurma::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateClassroom(@RequestBody DataTurma dataTurma) {
        Turma turma = turmaRepository.findById(dataTurma.id()).orElseThrow(EntityNotFoundException::new);

        turma.setQtdAulasSemanais(dataTurma.qtdAulasSemanais());
        turma.setHorarioInicio(dataTurma.horarioInicio());
        turma.setHorarioFim(dataTurma.horarioFim());
        turma.setTamanho(dataTurma.tamanho());
        turma.setGenero(dataTurma.genero());
        turma.setNivel(dataTurma.nivel());
        turma.setIdModalidade(dataTurma.idModalidade());
        turma.setCpfInstrutor(dataTurma.cpfInstrutor());

        turmaRepository.save(turma);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClassroom(@PathVariable Integer id) {
        turmaRepository.deleteById(id);
    }
}
