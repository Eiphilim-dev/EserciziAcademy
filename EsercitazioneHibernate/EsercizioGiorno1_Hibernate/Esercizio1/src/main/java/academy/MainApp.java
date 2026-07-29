package academy;

import academy.dao.AutomobileDao;
import academy.dao.IDao;
import academy.dao.PersonaDaoImpl;
import academy.model.Automobile;
import academy.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    static void main(String[] args) {

        IDao<Persona, Integer> personaDao = new PersonaDaoImpl();
        IDao<Automobile, Integer> automobileDao = new AutomobileDao();

        Persona p1 = new Persona("Mario", "Rossi", "Via Roma 10, Milano", "Ingegnere", 35);
        Persona p2 = new Persona("Giulia", "Bianchi", "Corso Italia 5, Torino", "Insegnante", 29);
        Persona p3 = new Persona("Luca", "Verdi", "Via Napoli 42, Roma", "Sviluppatore Software", 40);
        Persona p4 = new Persona("Elena", "Neri", "Via Dante 15, Firenze", "Sarta", 52);
        Persona p5 = new Persona("Alessandro", "Gialli", "Piazza Garibaldi 8, Napoli", "Medico", 45);

        Automobile a1 = new Automobile("Fiat", "500", "AB123CD",
                "ZFA31200001112233", "Anteriore");

        Automobile a2 = new Automobile("Alfa Romeo", "Giulia", "EF456GH",
                "ZAR95200004445566", "Posteriore");

        Automobile a3 = new Automobile("Audi", "A4 Avant", "IJ789KL",
                "WAUZZZ8K0DA123456", "Integrale Quattro");

        Automobile a4 = new Automobile("BMW", "Serie 3", "MN012OP",
                "WBA8E110009998877", "Posteriore");

        Automobile a5 = new Automobile("Tesla", "Model 3", "QR345ST",
                "5YJ3E1EA1KF000111", "Integrale Dual Motor");

        personaDao.save(p1);
        personaDao.save(p2);
        personaDao.save(p3);
        personaDao.save(p4);
        personaDao.save(p5);

        automobileDao.save(a1);
        automobileDao.save(a2);
        automobileDao.save(a3);
        automobileDao.save(a4);
        automobileDao.save(a5);

        List<Persona> persone = personaDao.findAll();
        persone.forEach(p -> System.out.println(p));

        List<Automobile> automobili = automobileDao.findAll();
        automobili.forEach(a -> System.out.println(a));

        Persona personaDaModificare = personaDao.findById(57);
        personaDaModificare.setNome("Alex");
        personaDao.update(personaDaModificare);

        Persona personaDaModificare1 = personaDao.findById(58);
        personaDao.delete(personaDaModificare1);
        personaDao.deleteAll();
    }
}
