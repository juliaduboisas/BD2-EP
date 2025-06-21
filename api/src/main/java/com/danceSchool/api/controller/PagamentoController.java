package com.danceSchool.api.controller;

import com.danceSchool.api.entity.pagamento.Pagamento;
import com.danceSchool.api.entity.pagamento.PagamentoRepository;
import com.danceSchool.api.entity.pagamento.DataPagamento;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @PostMapping
    public void create(@RequestBody DataPagamento data) {
        repository.save(new Pagamento(data));
    }

    @GetMapping
    public List<DataPagamento> getAll() {
        return repository.findAll().stream().map(DataPagamento::new).toList();
    }

    @GetMapping("/{id}")
    public DataPagamento getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataPagamento::new).orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}