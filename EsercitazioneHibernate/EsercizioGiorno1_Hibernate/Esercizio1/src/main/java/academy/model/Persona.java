package academy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "professione")
    private String professione;

    @Column(name = "eta")
    private int eta;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Automobile> automobili = new ArrayList<>();

    public Persona(String nome, String cognome, String indirizzo, String professione, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.professione = professione;
        this.eta = eta;
    }

    public void addAutomobile(Automobile auto) {
        this.automobili.add(auto);
        auto.setProprietario(this);
    }

}
