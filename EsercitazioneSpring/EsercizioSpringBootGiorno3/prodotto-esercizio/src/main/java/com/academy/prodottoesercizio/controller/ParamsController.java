package com.academy.prodottoesercizio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/testo")
    public String mostraTesto(Model model) {
        model.addAttribute("titolo", "Sono un titolo");
        model.addAttribute("tipo", "testo");
        model.addAttribute("messaggio", "Ciao! Questo è un messaggio.");
        return "params";

    }

    @GetMapping("/prodotto")
    public String mostraNomeProdotto(@RequestParam String nome, Model model) {
        model.addAttribute("titolo", "Nome prodotto venduto");
        model.addAttribute("tipo", "prodotto");
        model.addAttribute("nomeProdotto", nome);
        return "params";
    }

    @GetMapping("/quantita")
    public String mostraQuantitaProdotti(@RequestParam int quantita, Model model) {
        model.addAttribute("titolo", "Quantità prodotti venduti");
        model.addAttribute("tipo", "quantita");
        model.addAttribute("quantita", quantita);
        return "params";
    }

    @GetMapping("/dettaglio")
    public String mostraDescrizioneEPrezzo(
            @RequestParam String descrizione,
            @RequestParam double prezzo,
            Model model) {

        model.addAttribute("titolo", "Descrizione e prezzo prodotto");
        model.addAttribute("tipo", "dettaglio");
        model.addAttribute("descrizione", descrizione);
        model.addAttribute("prezzo", prezzo);
        return "params";
    }

    @GetMapping("/cliente/{nomeCliente}/prodotto")
    public String mostraClienteEProdotto(
            @PathVariable String nomeCliente,
            @RequestParam String prodotto,
            Model model) {

        model.addAttribute("titolo", "Cliente e prodotto venduto");
        model.addAttribute("tipo", "clienteProdotto");
        model.addAttribute("nomeCliente", nomeCliente);
        model.addAttribute("prodotto", prodotto);
        return "params";
    }
}
