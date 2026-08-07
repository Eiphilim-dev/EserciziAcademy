package com.example.esercizioseggio.service;

import com.example.esercizioseggio.models.dto.TesseraElettoraleDto;
import com.example.esercizioseggio.models.entity.Persona;
import com.example.esercizioseggio.models.entity.Seggio;
import com.example.esercizioseggio.models.entity.TesseraElettorale;
import com.example.esercizioseggio.repository.PersonaRepo;
import com.example.esercizioseggio.repository.SeggioRepo;
import com.example.esercizioseggio.repository.TesseraElettoraleRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TesseraElettoraleService {

    private final TesseraElettoraleRepo tesseraRepository;
    private final PersonaRepo personaRepository;
    private final SeggioRepo seggioRepository;

    public TesseraElettoraleService(
            TesseraElettoraleRepo tesseraRepository,
            PersonaRepo personaRepository,
            SeggioRepo seggioRepository
    ) {
        this.tesseraRepository = tesseraRepository;
        this.personaRepository = personaRepository;
        this.seggioRepository = seggioRepository;
    }

    @Transactional(readOnly = true)
    public List<TesseraElettoraleDto> findAll() {
        List<TesseraElettorale> tessere = tesseraRepository.findAll();
        List<TesseraElettoraleDto> risultati = new ArrayList<>();

        for (TesseraElettorale tessera : tessere) {
            risultati.add(toDto(tessera));
        }

        return risultati;
    }

    @Transactional(readOnly = true)
    public TesseraElettoraleDto findById(Long id) {
        TesseraElettorale tessera = tesseraRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tessera non trovata con id: " + id)
                );

        return toDto(tessera);
    }

    public TesseraElettoraleDto create(TesseraElettoraleDto dto) {
        Persona persona = personaRepository.findById(dto.persona_id())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Persona non trovata con id: " + dto.persona_id()
                        )
                );

        Seggio seggio = seggioRepository.findById(dto.seggio_id())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Seggio non trovato con id: " + dto.seggio_id()
                        )
                );

        if (tesseraRepository.existsByPersonaId(dto.persona_id())) {
            throw new RuntimeException("La persona possiede già una tessera");
        }

        TesseraElettorale tessera = new TesseraElettorale();

        tessera.setNumeroTessere(dto.numeroTessere());
        tessera.setScadenza(dto.scadenza());
        tessera.setPersona(persona);
        tessera.setSeggio(seggio);

        TesseraElettorale salvata = tesseraRepository.save(tessera);

        return toDto(salvata);
    }

    public TesseraElettoraleDto update(
            Long id,
            TesseraElettoraleDto dto
    ) {
        TesseraElettorale tessera = tesseraRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tessera non trovata con id: " + id)
                );

        Persona persona = personaRepository.findById(dto.persona_id())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Persona non trovata con id: " + dto.persona_id()
                        )
                );

        Seggio seggio = seggioRepository.findById(dto.seggio_id())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Seggio non trovato con id: " + dto.seggio_id()
                        )
                );

        tessera.setNumeroTessere(dto.numeroTessere());
        tessera.setScadenza(dto.scadenza());
        tessera.setPersona(persona);
        tessera.setSeggio(seggio);

        TesseraElettorale aggiornata = tesseraRepository.save(tessera);

        return toDto(aggiornata);
    }

    public void delete(Long id) {
        if (!tesseraRepository.existsById(id)) {
            throw new RuntimeException("Tessera non trovata con id: " + id);
        }

        tesseraRepository.deleteById(id);
    }

    private TesseraElettoraleDto toDto(TesseraElettorale tessera) {
        return new TesseraElettoraleDto(
                tessera.getId(),
                tessera.getNumeroTessere(),
                tessera.getScadenza(),
                tessera.getPersona().getId(),
                tessera.getSeggio().getId()
        );
    }
}