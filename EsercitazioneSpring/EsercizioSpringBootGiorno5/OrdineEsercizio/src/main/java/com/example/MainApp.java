package com.example;

import com.example.dao.OrdineDaoImpl;
import com.example.model.Articolo;
import com.example.model.Ordine;
import com.example.util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MainApp {
    static void main(String[] args) {
        OrdineDaoImpl ordineDAO = new OrdineDaoImpl();
            Articolo articolo1 = new Articolo(
                        "A001",
                        new BigDecimal("10.50"),
                        "Mouse",
                        "Mouse wireless",
                        "Informatica"
            );

            Articolo articolo2 = new Articolo(
                        "A002",
                        new BigDecimal("25.00"),
                        "Tastiera",
                        "Tastiera meccanica",
                        "Informatica"
                );

                Ordine ordine = new Ordine(
                        LocalDate.now(),
                        new BigDecimal("35.50"),
                        2
                );

                ordine.aggiungiArticolo(articolo1);
                ordine.aggiungiArticolo(articolo2);

                ordineDAO.salva(ordine);

                List<Ordine> ordini = ordineDAO.trovaTutti();

                for (Ordine o : ordini) {
                    System.out.println(o);
                }

                HibernateUtil.shutdown();
    }
}
