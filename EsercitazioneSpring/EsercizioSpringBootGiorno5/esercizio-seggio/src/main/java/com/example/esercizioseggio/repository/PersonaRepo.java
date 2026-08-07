package com.example.esercizioseggio.repository;

import com.example.esercizioseggio.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo
        extends JpaRepository<Persona, Long> {
}
