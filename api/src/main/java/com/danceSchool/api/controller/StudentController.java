package com.danceSchool.api.controller;

import com.danceSchool.api.aluno.DataAluno;
import com.danceSchool.api.aluno.Aluno;
import com.danceSchool.api.aluno.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("add")
    public void addStudent(@RequestBody DataAluno dataAluno){
        Aluno aluno = new Aluno(dataAluno);
        alunoRepository.save(aluno);
    }

    @GetMapping()
    public List<DataAluno> getAllStudents(){
        return alunoRepository.findAll()
                .stream()
                .map(DataAluno::new)
                .toList();
    }

    @GetMapping("/{cpf}")
    public DataAluno getStudentsByCpf(@PathVariable String cpf){
        return alunoRepository.findById(cpf).map(DataAluno::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/name/{name}")
    public List<DataAluno> getStudentByName(@PathVariable String name){
        return alunoRepository.findByNomeContainingIgnoreCase(name)
                .stream()
                .map(DataAluno::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody DataAluno dataAluno){
        Optional<Aluno> student = alunoRepository.findById(dataAluno.cpf());

        if(student.isEmpty()){
            throw new EntityNotFoundException("O aluno buscado não existe ou não foi encontrado");
        }

        student.get().setNome(dataAluno.nome());
        student.get().setGenero(dataAluno.genero());
        student.get().setDataNasc(dataAluno.dataNasc());
        student.get().setEmail(dataAluno.email());

        alunoRepository.save(student.get());
    }

    @DeleteMapping("/delete/{cpf}")
    public void deleteStudent(@PathVariable String cpf){
        alunoRepository.deleteById(cpf);
    }
}
