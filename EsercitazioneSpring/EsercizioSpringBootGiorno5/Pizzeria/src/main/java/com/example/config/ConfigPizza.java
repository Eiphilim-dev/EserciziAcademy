package com.example.config;

import com.example.models.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPizza {

    @Bean(name = "rossa")
    public Pizza pizzaRossa() {
        return new Pizza(
                "Margherita",
                7.50
        );
    }

    @Bean(name = "bianca")
    public Pizza pizzaBianca() {
        return new Pizza(
                "Pizza Bianca",
                8.00
        );
    }
}