package com.danceSchool.api.entity.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    List<Funcionario> findByNomeContaining(String nome);
    List<Funcionario> (String cpfAdm);
}
