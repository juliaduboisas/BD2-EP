package com.danceSchool.api.controller;

import com.danceSchool.api.entity.instrutor.Instrutor;
import com.danceSchool.api.entity.instrutor.InstrutorRepository;
import com.danceSchool.api.entity.instrutor.DataInstrutor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    public void create(@RequestBody DataInstrutor data) {
        repository.save(new Instrutor(data));
    }

    @GetMapping
    public List<DataInstrutor> getAll() {
        return repository.findAll().stream().map(DataInstrutor::new).toList();
    }

    @GetMapping("/{cpf}")
    public DataInstrutor getById(@PathVariable String cpf) {
        return repository.findById(cpf).map(DataInstrutor::new).orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable String cpf) {
        repository.deleteById(cpf);
    }
}