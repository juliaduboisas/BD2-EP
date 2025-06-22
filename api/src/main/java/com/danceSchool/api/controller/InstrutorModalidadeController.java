package com.danceSchool.api.controller;

import com.danceSchool.api.entity.id.InstrutorModalidadeId;
import com.danceSchool.api.entity.instrutorModalidade.DataInstrutorModalidade;
import com.danceSchool.api.entity.instrutorModalidade.InstrutorModalidade;
import com.danceSchool.api.entity.instrutorModalidade.InstrutorModalidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor-modalidade")
public class InstrutorModalidadeController {

    @Autowired
    private InstrutorModalidadeRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataInstrutorModalidade data) {
        repository.save(new InstrutorModalidade(data));
    }

    @GetMapping
    public ResponseEntity<List<DataInstrutorModalidade>> getAll() {
        var page = repository.findAll().stream().map(DataInstrutorModalidade::new).toList();
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{cpfInstrutor}/{idModalidade}")
    public ResponseEntity<DataInstrutorModalidade> getById(@PathVariable String cpfInstrutor, @PathVariable Integer idModalidade) {
        var instrutorModalidade = repository.findById(new InstrutorModalidadeId(cpfInstrutor, idModalidade))
                .map(DataInstrutorModalidade::new)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(instrutorModalidade);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataInstrutorModalidade data) {
        var instrutorModalidade = repository.findById(new InstrutorModalidadeId(data.cpfInstrutor(), data.idModalidade()))
                .orElseThrow(EntityNotFoundException::new);
        instrutorModalidade.setNivelCapacitacao(data.nivelCapacitacao());
        repository.save(instrutorModalidade);
    }

    @DeleteMapping("/{cpfInstrutor}/{idModalidade}")
    @Transactional
    public void delete(@PathVariable String cpfInstrutor, @PathVariable Integer idModalidade) {
        repository.deleteById(new InstrutorModalidadeId(cpfInstrutor, idModalidade));
    }
}
