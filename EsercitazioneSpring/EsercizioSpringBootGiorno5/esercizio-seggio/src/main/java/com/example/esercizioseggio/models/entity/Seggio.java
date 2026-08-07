package com.example.esercizioseggio.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seggi")
@NoArgsConstructor
@Getter
@Setter
public class Seggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seggio_id")
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 4)
    private String codice;

    @NotBlank
    private String sede;

    @NotBlank
    private String citta;

    @NotBlank
    private String provincia;

    @OneToMany(mappedBy = "seggio")
    private List<TesseraElettorale> tessere = new ArrayList<>();

    @PreRemove
    private void preRemove() {
        if (tessere != null) {
            for (TesseraElettorale tessera : tessere) {
                tessera.setSeggio(null);
            }
        }
    }

    public Seggio(String codice, String sede, String citta, String provincia) {
        this.codice = codice;
        this.sede = sede;
        this.citta = citta;
        this.provincia = provincia;
    }
}