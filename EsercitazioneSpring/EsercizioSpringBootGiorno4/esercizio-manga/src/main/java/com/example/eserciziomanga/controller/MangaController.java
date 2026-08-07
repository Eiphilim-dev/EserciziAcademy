package com.example.eserciziomanga.controller;

import com.example.eserciziomanga.dto.MangaDto;
import com.example.eserciziomanga.service.MangaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/manga")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3690)
public class MangaController {

    private final MangaService mangaService;

    @GetMapping
    public List<MangaDto> findAll() {
        return mangaService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MangaDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(mangaService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<MangaDto> create(@Valid @RequestBody MangaDto dto) {
        MangaDto salvato = mangaService.create(dto);
        return ResponseEntity.created(URI.create("/api/manga/" + salvato.manga_id())).body(salvato);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MangaDto> update(@PathVariable Integer id, @Valid @RequestBody MangaDto dto) {
        return ResponseEntity.ok(mangaService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        mangaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}