package com.example.eserciziomanga.controller;

import com.example.eserciziomanga.dto.FumetteriaDto;
import com.example.eserciziomanga.service.FumetteriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fumetterie")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3690)
public class FumetteriaController {

    private final FumetteriaService fumetteriaService;

    @GetMapping("/findAll")
    public List<FumetteriaDto> findAll() {
        return fumetteriaService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FumetteriaDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(fumetteriaService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<FumetteriaDto> create(@Valid @RequestBody FumetteriaDto dto) {
        FumetteriaDto salvata = fumetteriaService.create(dto);
        return ResponseEntity.created(URI.create("/api/fumetterie/" + salvata.fumetteria_id())).body(salvata);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FumetteriaDto> update(@PathVariable Integer id, @Valid @RequestBody FumetteriaDto dto) {
        return ResponseEntity.ok(fumetteriaService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        fumetteriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}