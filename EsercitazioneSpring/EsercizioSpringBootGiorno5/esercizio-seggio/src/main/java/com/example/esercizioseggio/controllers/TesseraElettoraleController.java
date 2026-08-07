package com.example.esercizioseggio.controllers;

import com.example.esercizioseggio.models.dto.TesseraElettoraleDto;
import com.example.esercizioseggio.service.PersonaService;
import com.example.esercizioseggio.service.TesseraElettoraleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tessere")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3360)
public class TesseraElettoraleController {
    private final TesseraElettoraleService tesseraElettoraleService;

    @GetMapping("/findAll")
    public List<TesseraElettoraleDto> findAll() {
        return tesseraElettoraleService.findAll();

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TesseraElettoraleDto> findById(@PathVariable Long id) {
        TesseraElettoraleDto tesseraDto = tesseraElettoraleService.findById(id);

        if (tesseraDto != null) {
            return ResponseEntity.ok(tesseraElettoraleService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity create(
            @Valid @RequestBody TesseraElettoraleDto dto
    ) {
        TesseraElettoraleDto salvata = tesseraElettoraleService.create(dto);

        return ResponseEntity
                .created(URI.create("/api/tessere/add" + salvata.persona_id()))
                .body(salvata);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TesseraElettoraleDto> update(
            @PathVariable Long id,
            @Valid @RequestBody TesseraElettoraleDto dto
    ) {
        return ResponseEntity.ok(tesseraElettoraleService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tesseraElettoraleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
