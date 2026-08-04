package app;

import config.ConfigMotore;
import model.Automobile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    static void main(String[] args) {
        System.out.println("=== Creazione ApplicationContext ===\n");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigMotore.class);
        System.out.println("\n - Context creato.\n");

        System.out.println("\n=== Recupero Bean Automobile ===\n");

        Automobile auto1 = context.getBean("autoElettrica", Automobile.class);
        Automobile auto2 = context.getBean("autoBenzina", Automobile.class);
        Automobile auto3 = context.getBean("autoDiesel", Automobile.class);

        auto1.mostraDettagli();
        auto2.mostraDettagli();

        System.out.println("\n=== Chiusura Spring ===\n");
        context.close();
    }
}
