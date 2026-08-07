package com.example.esercizioseggio.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonaDto(
        Long persona_id,

        @NotBlank
        String nome,

        @NotBlank
        String cognome,

        @NotBlank
        String codiceFiscale
) {}