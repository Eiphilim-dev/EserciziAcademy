package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Film {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titolo;

        private String categoria;

        @OneToMany(
                mappedBy = "film",
                orphanRemoval = true
        )
        @ToString.Exclude
        private List<Premio> premi = new ArrayList<>();


        public Film(String titolo, String categoria) {
            this.titolo = titolo;
            this.categoria = categoria;
        }

        public void aggiungiPremio(Premio premio) {
            premi.add(premio);
            premio.setFilm(this);
        }

        public void rimuoviPremio(Premio premio) {
            premi.remove(premio);
            premio.setFilm(null);
        }
}
