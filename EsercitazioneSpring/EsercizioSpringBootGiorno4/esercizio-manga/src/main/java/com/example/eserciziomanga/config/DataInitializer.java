package com.example.eserciziomanga.config;

import com.example.eserciziomanga.enums.GenereManga;
import com.example.eserciziomanga.model.Fumetteria;
import com.example.eserciziomanga.model.Manga;
import com.example.eserciziomanga.repository.FumetteriaRepository;
import com.example.eserciziomanga.repository.MangaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(FumetteriaRepository fumetteriaRepository, MangaRepository mangaRepository) {
        return args -> {
            Fumetteria f1 = new Fumetteria();
            f1.setNome("Manga World");
            f1.setIndirizzo("Via Roma 10, Catania");

            Fumetteria f2 = new Fumetteria();
            f2.setNome("Nakama Store");
            f2.setIndirizzo("Corso Italia 55, Catania");

            fumetteriaRepository.saveAll(List.of(f1, f2));

            Manga m1 = new Manga();
            m1.setTitolo("One Piece");
            m1.setAutore("Eiichiro Oda");
            m1.setGenere(GenereManga.SHONEN);
            m1.setFumetteria(f1);

            Manga m2 = new Manga();
            m2.setTitolo("Naruto");
            m2.setAutore("Masashi Kishimoto");
            m2.setGenere(GenereManga.SHONEN);
            m2.setFumetteria(f1);

            Manga m3 = new Manga();
            m3.setTitolo("Nana");
            m3.setAutore("Ai Yazawa");
            m3.setGenere(GenereManga.JOSEI);
            m3.setFumetteria(f2);

            mangaRepository.saveAll(List.of(m1, m2, m3));
        };
    }
}