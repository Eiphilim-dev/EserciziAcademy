import config.AppConfig;
import model.Smartphone;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@Configuration
//@ComponentScan("model")
public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== 1. CREAZIONE SPRING ===");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("\n=== BEAN ===");
        Smartphone smartphone = context.getBean(Smartphone.class);
        smartphone.accendi();
        smartphone.avviaGioco();

        System.out.println("\n=== CHIUSURA SPRING ===");
        context.close();
    }
}
