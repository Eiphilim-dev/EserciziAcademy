package com.example.eserciziomanga.dto;

import com.example.eserciziomanga.enums.GenereManga;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MangaDto(
        Integer manga_id,
        @NotBlank String titolo,
        String autore,
        @NotNull GenereManga genere,
        @NotNull Integer fumetteria_id
) {}