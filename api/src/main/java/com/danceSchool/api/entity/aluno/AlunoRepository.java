package com.danceSchool.api.entity.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
