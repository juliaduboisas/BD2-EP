package com.danceSchool.api.entity.modalidade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {
    public List<Modalidade> findByNomeContaining(String nome);
}
