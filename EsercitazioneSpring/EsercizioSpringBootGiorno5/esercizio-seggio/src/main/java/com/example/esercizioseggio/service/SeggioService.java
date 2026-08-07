package com.example.esercizioseggio.service;

import com.example.esercizioseggio.models.dto.SeggioDto;
import com.example.esercizioseggio.models.entity.Seggio;
import com.example.esercizioseggio.repository.SeggioRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SeggioService {

    private final SeggioRepo seggioRepo;

    public SeggioService(SeggioRepo seggioRepo) {
        this.seggioRepo = seggioRepo;
    }

    @Transactional(readOnly = true)
    public List<SeggioDto> findAll() {
        List<Seggio> seggi = seggioRepo.findAll();
        List<SeggioDto> risultati = new ArrayList<>();

        for (Seggio seggio : seggi) {
            risultati.add(toDto(seggio));
        }

        return risultati;
    }

    @Transactional(readOnly = true)
    public SeggioDto findById(Long id) {
        Seggio seggio = seggioRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Seggio non trovato con id: " + id)
                );

        return toDto(seggio);
    }

    public SeggioDto create(SeggioDto dto) {
        Seggio seggio = new Seggio();

        seggio.setCodice(dto.codice());
        seggio.setSede(dto.sede());
        seggio.setCitta(dto.citta());
        seggio.setProvincia(dto.provincia());

        Seggio salvato = seggioRepo.save(seggio);

        return toDto(salvato);
    }

    public SeggioDto update(Long id, SeggioDto dto) {
        Seggio seggio = seggioRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Seggio non trovato con id: " + id)
                );

        seggio.setCodice(dto.codice());
        seggio.setSede(dto.sede());
        seggio.setCitta(dto.citta());
        seggio.setProvincia(dto.provincia());

        Seggio aggiornato = seggioRepo.save(seggio);

        return toDto(aggiornato);
    }

    public void delete(Long id) {
        if (!seggioRepo.existsById(id)) {
            throw new RuntimeException("Seggio non trovato con id: " + id);
        }

        seggioRepo.deleteById(id);
    }

    private SeggioDto toDto(Seggio seggio) {
        return new SeggioDto(
                seggio.getId(),
                seggio.getCodice(),
                seggio.getSede(),
                seggio.getCitta(),
                seggio.getProvincia()
        );
    }
}