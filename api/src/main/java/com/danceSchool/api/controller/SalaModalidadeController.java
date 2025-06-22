package com.danceSchool.api.controller;

import com.danceSchool.api.entity.id.SalaModalidadeId;
import com.danceSchool.api.entity.salaModalidade.DataSalaModalidade;
import com.danceSchool.api.entity.salaModalidade.SalaModalidade;
import com.danceSchool.api.entity.salaModalidade.SalaModalidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala-modalidade")
public class SalaModalidadeController {

    @Autowired
    private SalaModalidadeRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataSalaModalidade data) {
        repository.save(new SalaModalidade(data));
    }

    @GetMapping
    public ResponseEntity<List<DataSalaModalidade>> getAll() {
        var page = repository.findAll().stream().map(DataSalaModalidade::new).toList();
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{idSala}/{idModalidade}")
    public ResponseEntity<DataSalaModalidade> getById(@PathVariable Integer idSala, @PathVariable Integer idModalidade) {
        var salaModalidade = repository.findById(new SalaModalidadeId(idSala, idModalidade))
                .map(DataSalaModalidade::new)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(salaModalidade);
    }

    @DeleteMapping("/{idSala}/{idModalidade}")
    @Transactional
    public void delete(@PathVariable Integer idSala, @PathVariable Integer idModalidade) {
        repository.deleteById(new SalaModalidadeId(idSala, idModalidade));
    }
}
