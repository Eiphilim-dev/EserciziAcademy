package com.example.esercizioseggio.repository;

import com.example.esercizioseggio.models.entity.Seggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeggioRepo
        extends JpaRepository<Seggio, Long> {
}
