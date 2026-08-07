package com.example.esercizioseggio.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tessere_elettorali")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TesseraElettorale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "tessera_id")
    private Long id;

    @Column(name = "numero_tessera", nullable = false, unique = true)
    private Long numeroTessere;

    @Column(nullable = false)
    private LocalDate scadenza;

    @OneToOne
    @JoinColumn(name = "persona_id" ,nullable = false, unique = true)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "seggio_id")
    private Seggio seggio;

    @PreRemove
    private void preRemove() {
        if (persona != null) {
            persona.setTesseraElettorale(null);
        }
    }

    public TesseraElettorale(Long numeroTessere, LocalDate scadenza, Persona persona, Seggio seggio) {
        this.numeroTessere = numeroTessere;
        this.scadenza = scadenza;
        this.persona = persona;
        this.seggio = seggio;
    }
}