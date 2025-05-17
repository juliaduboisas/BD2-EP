package com.danceSchool.api.controller;

import com.danceSchool.api.student.DataStudent;
import com.danceSchool.api.student.Student;
import com.danceSchool.api.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return studentRepository.findById(cpf).map(DataStudent::new).get();
    }
}
