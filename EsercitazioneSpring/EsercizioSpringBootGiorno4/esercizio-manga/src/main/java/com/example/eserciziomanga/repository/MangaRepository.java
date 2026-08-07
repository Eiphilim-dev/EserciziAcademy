package com.example.eserciziomanga.repository;

import com.example.eserciziomanga.enums.GenereManga;
import com.example.eserciziomanga.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga, Integer> {

    List<Manga> findByFumetteria_FumetteriaId(Integer fumetteriaId);

    List<Manga> findByTitolo(String titolo);

    List<Manga> findByAutore(String autore);

    List<Manga> findByGenere(GenereManga genere);
}