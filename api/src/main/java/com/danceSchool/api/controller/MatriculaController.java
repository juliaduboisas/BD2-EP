package com.danceSchool.api.controller;

import com.danceSchool.api.entity.matricula.Matricula;
import com.danceSchool.api.entity.matricula.MatriculaRepository;
import com.danceSchool.api.entity.matricula.DataMatricula;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @PostMapping
    public void create(@RequestBody DataMatricula data) {
        repository.save(new Matricula(data));
    }

    @GetMapping
    public List<DataMatricula> getAll() {
        return repository.findAll().stream().map(DataMatricula::new).toList();
    }

    @GetMapping("/{id}")
    public DataMatricula getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataMatricula::new).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping
    public void update(@RequestBody DataMatricula data) {
        Matricula matricula = repository.findById(data.id()).orElseThrow(EntityNotFoundException::new);
        matricula.setDataMatricula(data.dataMatricula());
        matricula.setValor(data.valor());
        repository.save(matricula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}