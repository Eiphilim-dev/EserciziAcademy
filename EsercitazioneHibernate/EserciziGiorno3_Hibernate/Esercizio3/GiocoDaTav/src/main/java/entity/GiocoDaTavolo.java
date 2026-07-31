package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "gioco_da_tavolo")
public class GiocoDaTavolo {

    @Id
    @Setter(AccessLevel.NONE)
    private String nome;

    @Column(name = "casa_produttrice",length = 100)
    private String casaProduttrice;

    @Column(name = "numero_min_giocatori")
    private Integer numeroMinGiocatori;

    @Column(name = "numero_max_giocatori")
    private Integer numeroMaxGiocatori;

    @Column(name = "etaMinima")
    private Integer etaMinima;

    @OneToMany(mappedBy = "giocoDaTavolo", cascade = CascadeType.ALL)
    private List<Partecipante> partecipanti;

    public GiocoDaTavolo(String casaProduttrice, Integer numeroMinGiocatori, Integer numeroMaxGiocatori, Integer etaMinima) {
        this.casaProduttrice = casaProduttrice;
        this.numeroMinGiocatori = numeroMinGiocatori;
        this.numeroMaxGiocatori = numeroMaxGiocatori;
        this.etaMinima = etaMinima;
    }

    public GiocoDaTavolo(String nome, String casaProduttrice, Integer numeroMinGiocatori, Integer numeroMaxGiocatori, Integer etaMinima) {
        this.nome = nome;
        this.casaProduttrice = casaProduttrice;
        this.numeroMinGiocatori = numeroMinGiocatori;
        this.numeroMaxGiocatori = numeroMaxGiocatori;
        this.etaMinima = etaMinima;
    }
}
