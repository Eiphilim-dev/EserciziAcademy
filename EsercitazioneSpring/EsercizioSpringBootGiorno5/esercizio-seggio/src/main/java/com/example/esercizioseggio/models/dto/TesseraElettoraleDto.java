package com.example.esercizioseggio.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record TesseraElettoraleDto(
        Long tessera_id,

        @NotNull
        @Positive
        Long numeroTessere,

        @NotNull
        LocalDate scadenza,

        @NotNull
        @Positive
        Long persona_id,

        @NotNull
        @Positive
        Long seggio_id
) {
}