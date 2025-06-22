package com.danceSchool.api.controller;

import com.danceSchool.api.entity.id.SalaEquipamentoId;
import com.danceSchool.api.entity.salaEquipamento.DataSalaEquipamento;
import com.danceSchool.api.entity.salaEquipamento.SalaEquipamento;
import com.danceSchool.api.entity.salaEquipamento.SalaEquipamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala-equipamento")
public class SalaEquipamentoController {

    @Autowired
    private SalaEquipamentoRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataSalaEquipamento data) {
        repository.save(new SalaEquipamento(data));
    }

    @GetMapping
    public ResponseEntity<List<DataSalaEquipamento>> getAll() {
        var page = repository.findAll().stream().map(DataSalaEquipamento::new).toList();
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{idSala}/{idEquipamento}")
    public ResponseEntity<DataSalaEquipamento> getById(@PathVariable Integer idSala, @PathVariable Integer idEquipamento) {
        var salaEquipamento = repository.findById(new SalaEquipamentoId(idEquipamento, idSala))
                .map(DataSalaEquipamento::new)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(salaEquipamento);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataSalaEquipamento data) {
        var salaEquipamento = repository.findById(new SalaEquipamentoId(data.idEquipamento(), data.idSala()))
                .orElseThrow(EntityNotFoundException::new);
        salaEquipamento.setQuantidade(data.quantidade());
        repository.save(salaEquipamento);
    }

    @DeleteMapping("/{idSala}/{idEquipamento}")
    @Transactional
    public void delete(@PathVariable Integer idSala, @PathVariable Integer idEquipamento) {
        repository.deleteById(new SalaEquipamentoId(idEquipamento, idSala));
    }
}
