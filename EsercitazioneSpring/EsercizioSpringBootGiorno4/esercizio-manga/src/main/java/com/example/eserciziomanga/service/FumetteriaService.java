package com.example.eserciziomanga.service;

import com.example.eserciziomanga.dto.FumetteriaDto;
import com.example.eserciziomanga.model.Fumetteria;
import com.example.eserciziomanga.repository.FumetteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FumetteriaService {

    private final FumetteriaRepository fumetteriaRepository;

    @Transactional(readOnly = true)
    public List<FumetteriaDto> findAll() {
        List<Fumetteria> fumetterie = fumetteriaRepository.findAll();
        List<FumetteriaDto> risultati = new ArrayList<>();

        for (Fumetteria f : fumetterie) {
            risultati.add(toDto(f));
        }

        return risultati;
    }

    @Transactional(readOnly = true)
    public FumetteriaDto findById(Integer id) {
        Fumetteria fumetteria = fumetteriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fumetteria non trovata con id: " + id));

        return toDto(fumetteria);
    }

    public FumetteriaDto create(FumetteriaDto dto) {
        Fumetteria fumetteria = new Fumetteria();
        fumetteria.setNome(dto.nome());
        fumetteria.setIndirizzo(dto.indirizzo());

        Fumetteria salvata = fumetteriaRepository.save(fumetteria);
        return toDto(salvata);
    }

    public FumetteriaDto update(Integer id, FumetteriaDto dto) {
        Fumetteria fumetteria = fumetteriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fumetteria non trovata con id: " + id));

        fumetteria.setNome(dto.nome());
        fumetteria.setIndirizzo(dto.indirizzo());

        Fumetteria aggiornata = fumetteriaRepository.save(fumetteria);
        return toDto(aggiornata);
    }

    public void delete(Integer id) {
        if (!fumetteriaRepository.existsById(id)) {
            throw new RuntimeException("Fumetteria non trovata con id: " + id);
        }
        fumetteriaRepository.deleteById(id);
    }

    private FumetteriaDto toDto(Fumetteria fumetteria) {
        return new FumetteriaDto(
                fumetteria.getFumetteriaId(),
                fumetteria.getNome(),
                fumetteria.getIndirizzo()
        );
    }
}