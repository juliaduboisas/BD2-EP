package com.danceSchool.api.controller;

import com.danceSchool.api.student.DataStudent;
import com.danceSchool.api.student.Student;
import com.danceSchool.api.student.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("add")
    public void addStudent(@RequestBody DataStudent dataStudent){
        Student student = new Student(dataStudent);
        studentRepository.save(student);
    }

    @GetMapping()
    public List<DataStudent> getAllStudents(){
        return studentRepository.findAll()
                .stream()
                .map(DataStudent::new)
                .toList();
    }

    @GetMapping("/{cpf}")
    public DataStudent getStudentsByCpf(@PathVariable String cpf){
        return studentRepository.findById(cpf).map(DataStudent::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/name/{name}")
    public List<DataStudent> getStudentByName(@PathVariable String name){
        return studentRepository.findByNomeContainingIgnoreCase(name)
                .stream()
                .map(DataStudent::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody DataStudent dataStudent){
        Optional<Student> student = studentRepository.findById(dataStudent.cpf());

        if(student.isEmpty()){
            throw new EntityNotFoundException("O aluno buscado não existe ou não foi encontrado");
        }

        student.get().setNome(dataStudent.nome());
        student.get().setGenero(dataStudent.genero());
        student.get().setDataNasc(dataStudent.dataNasc());
        student.get().setEmail(dataStudent.email());

        studentRepository.save(student.get());
    }

    @DeleteMapping("/delete/{cpf}")
    public void deleteStudent(@PathVariable String cpf){
        studentRepository.deleteById(cpf);
    }
}
