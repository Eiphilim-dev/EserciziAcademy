package config;

import model.Motore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Configuration
@Import(ConfigAutomobile.class)
public class ConfigMotore {

    @Lazy
    @Bean(name = "elettrico")
    public Motore motore1() {
        return new Motore("Elettrica");

    }

    @Bean(name = "benzina")
    public Motore motore2() {
        return new Motore("Benzina");

    }

    @Bean(name = "diesel")
    public Motore motore3() {
        return new Motore("Diesel");

    }
}
