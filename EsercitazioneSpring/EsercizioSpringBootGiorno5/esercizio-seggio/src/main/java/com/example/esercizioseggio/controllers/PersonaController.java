package com.example.esercizioseggio.controllers;

import com.example.esercizioseggio.models.dto.PersonaDto;
import com.example.esercizioseggio.service.PersonaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/persone")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3360)
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping("/findAll")
    public List<PersonaDto> findAll() {
        return personaService.findAll();

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PersonaDto> findById(@PathVariable Long id) {
        PersonaDto personaDto = personaService.findById(id);

        if (personaDto != null) {
            return ResponseEntity.ok(personaService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity create(
            @Valid @RequestBody PersonaDto dto
            ) {
        PersonaDto salvata = personaService.create(dto);

        return ResponseEntity
                .created(URI.create("/api/persone/" + salvata.persona_id()))
                .body(salvata);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaDto> update(
            @PathVariable Long id,
            @Valid @RequestBody PersonaDto dto
    ) {
        return ResponseEntity.ok(personaService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
