package com.danceSchool.api.controller;

import com.danceSchool.api.entity.turmaSala.TurmaSala;
import com.danceSchool.api.entity.turmaSala.TurmaSalaRepository;
import com.danceSchool.api.entity.turmaSala.DataTurmaSala;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma-sala")
public class TurmaSalaController {

    @Autowired
    private TurmaSalaRepository repository;

    @PostMapping
    public void create(@RequestBody DataTurmaSala data) {
        repository.save(new TurmaSala(data));
    }

    @GetMapping
    public List<DataTurmaSala> getAll() {
        return repository.findAll().stream().map(DataTurmaSala::new).toList();
    }

    @GetMapping("/{id}")
    public DataTurmaSala getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataTurmaSala::new).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping
    public void update(@RequestBody DataTurmaSala data) {
        TurmaSala turmaSala = repository.findById(data.id()).orElseThrow(EntityNotFoundException::new);
        turmaSala.setInicioLocacao(data.inicioLocacao());
        turmaSala.setFimLocacao(data.fimLocacao());
        repository.save(turmaSala);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}