package com.danceSchool.api.controller;

import com.danceSchool.api.entity.equipamento.Equipamento;
import com.danceSchool.api.entity.equipamento.EquipamentoRepository;
import com.danceSchool.api.entity.equipamento.DataEquipamento;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository repository;

    @PostMapping
    public void create(@RequestBody DataEquipamento data) {
        repository.save(new Equipamento(data));
    }

    @GetMapping
    public List<DataEquipamento> getAll() {
        return repository.findAll().stream().map(DataEquipamento::new).toList();
    }

    @GetMapping("/{id}")
    public DataEquipamento getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataEquipamento::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/tipo/{tipo}")
    public List<DataEquipamento> getByTipo(@PathVariable String tipo) {
        return repository.findByTipoContainingIgnoreCase(tipo).stream().map(DataEquipamento::new).toList();
    }

    @PutMapping
    public void update(@RequestBody DataEquipamento data) {
        Equipamento equipamento = repository.findById(data.id()).orElseThrow(EntityNotFoundException::new);
        equipamento.setTipo(data.tipo());
        repository.save(equipamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}