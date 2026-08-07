package com.example.eserciziomanga.service;

import com.example.eserciziomanga.dto.MangaDto;
import com.example.eserciziomanga.model.Fumetteria;
import com.example.eserciziomanga.model.Manga;
import com.example.eserciziomanga.repository.FumetteriaRepository;
import com.example.eserciziomanga.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MangaService {

    private final MangaRepository mangaRepository;
    private final FumetteriaRepository fumetteriaRepository;

    @Transactional(readOnly = true)
    public List<MangaDto> findAll() {
        List<Manga> mangaList = mangaRepository.findAll();
        List<MangaDto> risultati = new ArrayList<>();

        for (Manga manga : mangaList) {
            risultati.add(toDto(manga));
        }

        return risultati;
    }

    @Transactional(readOnly = true)
    public MangaDto findById(Integer id) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga non trovato con id: " + id));

        return toDto(manga);
    }

    public MangaDto create(MangaDto dto) {
        Fumetteria fumetteria = fumetteriaRepository.findById(dto.fumetteria_id())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fumetteria non trovata con id: " + dto.fumetteria_id()
                        )
                );

        Manga manga = new Manga();

        manga.setTitolo(dto.titolo());
        manga.setAutore(dto.autore());
        manga.setGenere(dto.genere());
        manga.setFumetteria(fumetteria);

        Manga salvato = mangaRepository.save(manga);

        return toDto(salvato);
    }

    public MangaDto update(Integer id, MangaDto dto) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Manga non trovato con id: " + id)
                );

        Fumetteria fumetteria = fumetteriaRepository.findById(dto.fumetteria_id())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fumetteria non trovata con id: " + dto.fumetteria_id()
                        )
                );

        manga.setTitolo(dto.titolo());
        manga.setAutore(dto.autore());
        manga.setGenere(dto.genere());
        manga.setFumetteria(fumetteria);

        Manga aggiornato = mangaRepository.save(manga);

        return toDto(aggiornato);
    }

    public void delete(Integer id) {
        if (!mangaRepository.existsById(id)) {
            throw new RuntimeException("Manga non trovato con id: " + id);
        }
        mangaRepository.deleteById(id);
    }

    private MangaDto toDto(Manga manga) {
        return new MangaDto(
                manga.getMangaId(),
                manga.getTitolo(),
                manga.getAutore(),
                manga.getGenere(),
                manga.getFumetteria().getFumetteriaId()
        );
    }
}