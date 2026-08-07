package com.example.eserciziomanga.model;

import com.example.eserciziomanga.enums.GenereManga;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "manga")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "manga_id")
    private Integer mangaId;

    @NotBlank
    private String titolo;

    private String autore;

    @NotNull
    @Enumerated(EnumType.STRING)
    private GenereManga genere;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fumetteria_id", nullable = false)
    private Fumetteria fumetteria;
}