package com.danceSchool.api.controller;

import com.danceSchool.api.entity.campeonato.Campeonato;
import com.danceSchool.api.entity.campeonato.CampeonatoRepository;
import com.danceSchool.api.entity.campeonato.DataCampeonato;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository repository;

    @PostMapping
    public void create(@RequestBody DataCampeonato data) {
        repository.save(new Campeonato(data));
    }

    @GetMapping
    public List<DataCampeonato> getAll() {
        return repository.findAll().stream().map(DataCampeonato::new).toList();
    }

    @GetMapping("/{id}")
    public DataCampeonato getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataCampeonato::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/data/{data}")
    public List<DataCampeonato> getByData(@PathVariable Date data) {
        return repository.findByData(data).stream().map(DataCampeonato::new).toList();
    }

    @PutMapping
    public void update(@RequestBody DataCampeonato data) {
        Campeonato campeonato = repository.findById(data.id()).orElseThrow(EntityNotFoundException::new);
        campeonato.setData(data.data());
        campeonato.setCategoria(data.categoria());
        campeonato.setPremiacao(data.premiacao());
        campeonato.setValorPremiacao(data.valorPremiacao());
        campeonato.setStatus(data.status());
        repository.save(campeonato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}