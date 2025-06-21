package com.danceSchool.api.controller;

import com.danceSchool.api.entity.inscricao.Inscricao;
import com.danceSchool.api.entity.inscricao.InscricaoRepository;
import com.danceSchool.api.entity.inscricao.DataInscricao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoRepository repository;

    @PostMapping
    public void create(@RequestBody DataInscricao data) {
        repository.save(new Inscricao(data));
    }

    @GetMapping
    public List<DataInscricao> getAll() {
        return repository.findAll().stream().map(DataInscricao::new).toList();
    }

    @GetMapping("/{id}")
    public DataInscricao getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataInscricao::new).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping
    public void update(@RequestBody DataInscricao data) {
        Inscricao inscricao = repository.findById(data.id()).orElseThrow(EntityNotFoundException::new);
        inscricao.setTaxa(data.taxa());
        inscricao.setDataInsc(data.dataInsc());
        repository.save(inscricao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}