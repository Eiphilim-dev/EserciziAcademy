package com.example;

import com.example.config.ConfigOrdinazione;
import com.example.models.Ordinazione;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

            System.out.println("=== Creazione ApplicationContext ===");

            AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(
                            ConfigOrdinazione.class
                    );

            System.out.println("=== Recupero ordinazione ===");

            Ordinazione ordinazione =
                    context.getBean(
                            "ordinazione",
                            Ordinazione.class
                    );

            ordinazione.mostraDettagli();

            System.out.println("=== Chiusura Spring ===");

            context.close();
    }
}
