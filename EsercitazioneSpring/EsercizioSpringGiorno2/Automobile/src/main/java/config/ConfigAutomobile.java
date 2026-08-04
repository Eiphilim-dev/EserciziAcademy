package config;

import model.Automobile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAutomobile {

    @Bean
    public Automobile autoElettrica(@Qualifier("elettrico") model.Motore motore) {
        Automobile auto = new Automobile("Tesla Model 3");
        auto.setMotore(motore);
        return auto;

    }

    @Bean
    public Automobile autoBenzina(@Qualifier("benzina") model.Motore motore) {
        Automobile auto = new Automobile("Golf GTI");
        auto.setMotore(motore);
        return auto;

    }

    @Bean
    public Automobile autoDiesel(@Qualifier("diesel") model.Motore motore) {
        Automobile auto = new Automobile("BMW 320d");
        auto.setMotore(motore);
        return auto;

    }
}
