package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.hibernate.annotations.Audited;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Audited.Table(name = "articolo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Articolo {

    @Id
    private String codice;

    private BigDecimal prezzo;

    private String nome;

    private String descrizione;

    private String categoria;

    @ManyToMany(mappedBy = "articoli")
    @ToString.Exclude
    private Set<Ordine> ordini = new HashSet<>();

    public Articolo(
            String codice,
            BigDecimal prezzo,
            String nome,
            String descrizione,
            String categoria
    ) {
        this.codice = codice;
        this.prezzo = prezzo;
        this.nome = nome;
        this.descrizione = descrizione;
        this.categoria = categoria;
    }
}
