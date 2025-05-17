package com.danceSchool.api.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByNomeContainingIgnoreCase(String nome);
}
