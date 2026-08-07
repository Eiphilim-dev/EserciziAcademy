package com.example.eserciziomanga.dto;

import jakarta.validation.constraints.NotBlank;

public record FumetteriaDto(
        Integer fumetteria_id,
        @NotBlank String nome,
        String indirizzo
) {}