package com.danceSchool.api.controller;

import com.danceSchool.api.entity.administrativo.Administrativo;
import com.danceSchool.api.entity.administrativo.AdministrativoRepository;
import com.danceSchool.api.entity.administrativo.DataAdministrativo;
import com.danceSchool.api.enums.Nivel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrativo")
public class AdministrativoController {

    @Autowired
    private AdministrativoRepository repository;

    @PostMapping
    public void create(@RequestBody DataAdministrativo data) {
        repository.save(new Administrativo(data));
    }

    @GetMapping
    public List<DataAdministrativo> getAll() {
        return repository.findAll().stream().map(DataAdministrativo::new).toList();
    }

    @GetMapping("/{cpf}")
    public DataAdministrativo getById(@PathVariable String cpf) {
        return repository.findById(cpf).map(DataAdministrativo::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/nivel/{nivel}")
    public List<DataAdministrativo> getByNivel(@PathVariable Integer nivel) {
        return repository.findByNivelAcessos(nivel).stream().map(DataAdministrativo::new).toList();
    }

    @PutMapping
    public void update(@RequestBody DataAdministrativo data) {
        Administrativo administrativo = repository.findById(data.cpf()).orElseThrow(EntityNotFoundException::new);
        administrativo.setNivelAcessos(data.nivelAcessos());
        repository.save(administrativo);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable String cpf) {
        repository.deleteById(cpf);
    }
}