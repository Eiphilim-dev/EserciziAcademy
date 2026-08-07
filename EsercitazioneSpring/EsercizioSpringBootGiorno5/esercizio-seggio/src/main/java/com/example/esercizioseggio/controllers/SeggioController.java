package com.example.esercizioseggio.controllers;

import com.example.esercizioseggio.models.dto.SeggioDto;
import com.example.esercizioseggio.service.SeggioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/seggi")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3360)
public class SeggioController {
    private final SeggioService seggioService;

    @GetMapping("/findAll")
    public List<SeggioDto> findAll() {
        return seggioService.findAll();

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SeggioDto> findById(@PathVariable Long id) {
        SeggioDto seggioDto = seggioService.findById(id);

        if (seggioDto != null) {
            return ResponseEntity.ok(seggioService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity create(
            @Valid @RequestBody SeggioDto dto
    ) {
        SeggioDto salvata = seggioService.create(dto);

        return ResponseEntity
                .created(URI.create("/api/seggi/add" + salvata.seggio_id()))
                .body(salvata);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SeggioDto> update(
            @PathVariable Long id,
            @Valid @RequestBody SeggioDto dto
    ) {
        return ResponseEntity.ok(seggioService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        seggioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
