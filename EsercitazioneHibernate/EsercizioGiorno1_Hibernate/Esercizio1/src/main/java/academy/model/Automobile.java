package academy.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "automobile")
public class Automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modello", nullable = false)
    private String modello;

    @Column(name = "targa", nullable = false, unique = true)
    private String targa;

    @Column(name = "numero_telaio", nullable = false,  unique = true)
    private String numeroTelaio;

    @Column(name = "tipo_trazione", nullable = false)
    private String tipoTrazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona proprietario;

    public Automobile(String marca, String modello, String targa, String numeroTelaio, String tipoTrazione) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.numeroTelaio = numeroTelaio;
        this.tipoTrazione = tipoTrazione;

    }
}
