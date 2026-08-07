package com.example.eserciziomanga.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fumetteria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Fumetteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "fumetteria_id")
    private Integer fumetteriaId;

    @NotBlank
    private String nome;

    private String indirizzo;

    @OneToMany(
            mappedBy = "fumetteria",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    @ToString.Exclude
    private List<Manga> mangaList = new ArrayList<>();
}