package com.example.eserciziomanga.repository;

import com.example.eserciziomanga.model.Fumetteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FumetteriaRepository
        extends JpaRepository<Fumetteria, Integer> {
}