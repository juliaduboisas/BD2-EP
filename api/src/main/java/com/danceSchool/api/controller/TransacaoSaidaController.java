package com.danceSchool.api.controller;

import com.danceSchool.api.entity.transacaoSaida.TransacaoSaida;
import com.danceSchool.api.entity.transacaoSaida.TransacaoSaidaRepository;
import com.danceSchool.api.entity.transacaoSaida.DataTransacaoSaida;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao-saida")
public class TransacaoSaidaController {

    @Autowired
    private TransacaoSaidaRepository repository;

    @PostMapping
    public void create(@RequestBody DataTransacaoSaida data) {
        repository.save(new TransacaoSaida(data));
    }

    @GetMapping
    public List<DataTransacaoSaida> getAll() {
        return repository.findAll().stream().map(DataTransacaoSaida::new).toList();
    }

    @GetMapping("/{id}")
    public DataTransacaoSaida getById(@PathVariable Integer id) {
        return repository.findById(id).map(DataTransacaoSaida::new).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping
    public void update(@RequestBody DataTransacaoSaida data) {
        TransacaoSaida transacaoSaida = repository.findById(data.id()).orElseThrow(EntityNotFoundException::new);
        transacaoSaida.setValor(data.valor());
        transacaoSaida.setDataHora(data.dataHora());
        transacaoSaida.setDescricao(data.descricao());
        transacaoSaida.setReceptor(data.receptor());
        transacaoSaida.setIdNotaFiscal(data.idNotaFiscal());
        repository.save(transacaoSaida);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}