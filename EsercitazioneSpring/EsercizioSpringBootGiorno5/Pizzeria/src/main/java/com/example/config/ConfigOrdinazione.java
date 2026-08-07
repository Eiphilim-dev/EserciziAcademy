package com.example.config;

import com.example.models.Ordinazione;
import com.example.models.Pizza;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigPizza.class)
public class ConfigOrdinazione {

    @Bean
    public Ordinazione ordinazione(
            @Qualifier("rossa") Pizza pizzaRossa,
            @Qualifier("bianca") Pizza pizzaBianca
    ) {
        Ordinazione ordinazione = new Ordinazione();

        ordinazione.setPizzaRossa(pizzaRossa);
        ordinazione.setPizzaBianca(pizzaBianca);

        return ordinazione;
    }
}
