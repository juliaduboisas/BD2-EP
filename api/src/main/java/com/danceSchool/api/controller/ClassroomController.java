package com.danceSchool.api.controller;

import com.danceSchool.api.classroom.Classroom;
import com.danceSchool.api.classroom.ClassroomRepository;
import com.danceSchool.api.classroom.DataClassroom;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    ClassroomRepository classroomRepository;

    @PostMapping("/add")
    public void addClassroom(@RequestBody DataClassroom dataClassroom) {
        Classroom classroom = new Classroom(dataClassroom);
        classroomRepository.save(classroom);
    }

    @GetMapping
    public List<DataClassroom> getAllClassrooms() {
        return classroomRepository.findAll()
                .stream()
                .map(DataClassroom::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DataClassroom getClassroomById(@PathVariable Integer id) {
        return classroomRepository.findById(id).map(DataClassroom::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/modality/{id_modalidade}")
    public List<DataClassroom> getClassroomByModality(@PathVariable Integer idModalidade) {
        return classroomRepository.findAllByIdModalidade(idModalidade)
                .stream()
                .map(DataClassroom::new)
                .toList();
    }

    @GetMapping("/instructor/{instructor}")
    public List<DataClassroom> getClassroomByInstructor(@PathVariable String cpfInstrutor) {
        return classroomRepository.findAllByCpfInstrutor(cpfInstrutor)
                .stream()
                .map(DataClassroom::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateClassroom(@RequestBody DataClassroom dataClassroom) {
        Classroom classroom = classroomRepository.findById(dataClassroom.id()).orElseThrow(EntityNotFoundException::new);

        classroom.setQtdAulasSemanais(dataClassroom.qtdAulasSemanais());
        classroom.setHorarioInicio(dataClassroom.horarioInicio());
        classroom.setHorarioFim(dataClassroom.horarioFim());
        classroom.setTamanho(dataClassroom.tamanho());
        classroom.setGenero(dataClassroom.genero());
        classroom.setNivel(dataClassroom.nivel());
        classroom.setIdModalidade(dataClassroom.idModalidade());
        classroom.setCpfInstrutor(dataClassroom.cpfInstrutor());

        classroomRepository.save(classroom);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClassroom(@PathVariable Integer id) {
        classroomRepository.deleteById(id);
    }
}
