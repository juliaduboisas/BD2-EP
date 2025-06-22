package com.danceSchool.api.controller;

import com.danceSchool.api.entity.transacaoEntrada.TransacaoEntrada;
import com.danceSchool.api.entity.transacaoEntrada.TransacaoEntradaRepository;
import com.danceSchool.api.entity.transacaoEntrada.DataTransacaoEntrada;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao-entrada")
public class TransacaoEntradaController {

    @Autowired
    private TransacaoEntradaRepository repository;

    @PostMapping
    public void create(@RequestBody DataTransacaoEntrada data) {
        repository.save(new TransacaoEntrada(data));
    }

    @GetMapping
    public List<DataTransacaoEntrada> getAll() {
        return repository.findAll().stream().map(DataTransacaoEntrada::new).toList();
    }

    @GetMapping("/{id}")
    public DataTransacaoEntrada getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataTransacaoEntrada::new).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping
    public void update(@RequestBody DataTransacaoEntrada data) {
        TransacaoEntrada transacaoEntrada = repository.findById(data.id()).orElseThrow(EntityNotFoundException::new);
        transacaoEntrada.setValor(data.valor());
        transacaoEntrada.setDataHora(data.dataHora());
        transacaoEntrada.setDescricao(data.descricao());
        transacaoEntrada.setEmissor(data.emissor());
        transacaoEntrada.setIdNotaFiscal(data.idNotaFiscal());
        repository.save(transacaoEntrada);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}