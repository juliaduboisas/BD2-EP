package com.danceSchool.api.sala;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
    public List<Sala> findByTitleContainingIgnoreCase(String title);
}
