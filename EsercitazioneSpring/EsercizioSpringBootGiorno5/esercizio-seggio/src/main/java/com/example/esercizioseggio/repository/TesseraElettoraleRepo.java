package com.example.esercizioseggio.repository;

import com.example.esercizioseggio.models.entity.TesseraElettorale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TesseraElettoraleRepo
        extends JpaRepository<TesseraElettorale, Long> {

//    @Query("SELECT p.id FROM Persona p")
    boolean existsByPersonaId(Long idPersona);
}
