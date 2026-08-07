package com.example.esercizioseggio.models.dto;

import jakarta.validation.constraints.NotBlank;

public record SeggioDto(
        Long seggio_id,

        @NotBlank
        String codice,

        @NotBlank
        String sede,

        @NotBlank
        String citta,

        @NotBlank
        String provincia
) {}