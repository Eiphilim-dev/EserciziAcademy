package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "premio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Premio {

    @Id
    private Long id;

    private String nome;

    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    @ToString.Exclude
    private Film film;

    public Premio(Long id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }
}
