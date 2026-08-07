package com.example.esercizioseggio.service;

import com.example.esercizioseggio.models.dto.PersonaDto;
import com.example.esercizioseggio.models.entity.Persona;
import com.example.esercizioseggio.repository.PersonaRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonaService {

    private final PersonaRepo personaRepo;

    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    @Transactional(readOnly = true)
    public List<PersonaDto> findAll() {
        List<Persona> persone = personaRepo.findAll();
        List<PersonaDto> risultati = new ArrayList<>();

        for (Persona persona : persone) {
            risultati.add(toDto(persona));
        }

        return risultati;
    }

    @Transactional(readOnly = true)
    public PersonaDto findById(Long id) {
        Persona persona = personaRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Persona non trovata con id: " + id)
                );

        return toDto(persona);
    }

    public PersonaDto create(PersonaDto dto) {
        Persona persona = new Persona();

        persona.setNome(dto.nome());
        persona.setCognome(dto.cognome());
        persona.setCodiceFiscale(dto.codiceFiscale());

        Persona salvata = personaRepo.save(persona);

        return toDto(salvata);
    }

    public PersonaDto update(Long id, PersonaDto dto) {
        Persona persona = personaRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Persona non trovata con id: " + id)
                );

        persona.setNome(dto.nome());
        persona.setCognome(dto.cognome());
        persona.setCodiceFiscale(dto.codiceFiscale());

        Persona aggiornata = personaRepo.save(persona);

        return toDto(aggiornata);
    }

    public void delete(Long id) {
        if (!personaRepo.existsById(id)) {
            throw new RuntimeException("Persona non trovata con id: " + id);
        }

        personaRepo.deleteById(id);
    }

    private PersonaDto toDto(Persona persona) {
        return new PersonaDto(
                persona.getId(),
                persona.getNome(),
                persona.getCognome(),
                persona.getCodiceFiscale()
        );
    }
}