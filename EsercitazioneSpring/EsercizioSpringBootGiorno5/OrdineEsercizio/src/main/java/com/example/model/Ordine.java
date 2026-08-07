package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ordine")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataRichiesta;

    private BigDecimal prezzoTotale;

    private int numeroArticoli;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ordine_articolo",
            joinColumns = @JoinColumn(name = "ordine_id"),
            inverseJoinColumns = @JoinColumn(name = "articolo_codice")
    )
    @ToString.Exclude
    private Set<Articolo> articoli = new HashSet<>();

    public Ordine(
            LocalDate dataRichiesta,
            BigDecimal prezzoTotale,
            int numeroArticoli
    ) {
        this.dataRichiesta = dataRichiesta;
        this.prezzoTotale = prezzoTotale;
        this.numeroArticoli = numeroArticoli;
    }

    public void aggiungiArticolo(Articolo articolo) {
        articoli.add(articolo);
        articolo.getOrdini().add(this);
    }

    public void rimuoviArticolo(Articolo articolo) {
        articoli.remove(articolo);
        articolo.getOrdini().remove(this);
    }
}
