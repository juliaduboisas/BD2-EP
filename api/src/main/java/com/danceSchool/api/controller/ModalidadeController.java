package com.danceSchool.api.controller;

import com.danceSchool.api.entity.modalidade.DataModalidade;
import com.danceSchool.api.entity.modalidade.Modalidade;
import com.danceSchool.api.entity.modalidade.ModalidadeRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modality")
public class ModalidadeController {
    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @PostMapping("/add")
    public void add(@RequestBody DataModalidade dataModalidade) {
        Modalidade modalidade = new Modalidade();
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
    public void updateModalidade(@RequestBody DataModalidade dataModalidade) {
        Optional<Modalidade> modalidade = modalidadeRepository.findById(dataModalidade.id());

        if(modalidade.isEmpty()){
            throw new EntityNotFoundException("A modalidade busca não existe ou não foi encontrada.");
        }

        modalidade.get().setNome(dataModalidade.nome());

        modalidadeRepository.save(modalidade.get());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteModalidade(@PathVariable Integer id) {
        modalidadeRepository.deleteById(id);
    }
}
