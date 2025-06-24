package com.danceSchool.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danceSchool.api.entity.modalidade.DataModalidade;
import com.danceSchool.api.entity.modalidade.Modalidade;
import com.danceSchool.api.entity.modalidade.ModalidadeRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/modality")
public class ModalidadeController {
    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @PostMapping("/add")
    public void add(@RequestBody DataModalidade dataModalidade) {
        Modalidade modalidade = new Modalidade(dataModalidade);
        modalidadeRepository.save(modalidade);
    }

    @GetMapping()
    public List<DataModalidade> findAll() {
        return modalidadeRepository.findAll()
                .stream()
                .map(DataModalidade::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DataModalidade getModalidadeById(@PathVariable Integer id) {
        return modalidadeRepository.findById(id).map(DataModalidade::new).orElseThrow(EntityExistsException::new);
    }

    @GetMapping("/by-name/{nome}")
    public List<DataModalidade> getModalidadeByNome(@PathVariable String nome) {
        return modalidadeRepository.findByNomeContaining(nome)
                .stream()
                .map(DataModalidade::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateModalidade(@RequestBody Integer id) {
        Optional<Modalidade> modalidade = modalidadeRepository.findById(id);

        if(modalidade.isEmpty()){
            throw new EntityNotFoundException("A modalidade busca não existe ou não foi encontrada.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteModalidade(@PathVariable Integer id) {
        modalidadeRepository.deleteById(id);
    }
}
