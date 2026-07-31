package entity;

import enums.StatoRichiesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "richiesta_ferie")
public class RichiestaFerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "data_creazione",  nullable = false)
    private LocalDate dataCreazione;

    @Column(name = "data_modifica")
    private LocalDate dataModifica;

    @Column(name = "email_aziendale",  nullable = false)
    private String emailAziendale;

    @Column(name = "giorno_inizio",  nullable = false)
    private LocalDate giornoInizio;

    @Column(name = "giorno_fine",  nullable = false)
    private LocalDate giornoFine;

    @Column(name = "motivazione",  nullable = false)
    private String motivazione;

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoRichiesta stato;

    @Column(name = "motivazione_rifiuto")
    private String motivazioneRifiuto;

    public RichiestaFerie(String emailAziendale, LocalDate giornoInizio, LocalDate giornoFine, String motivazione) {
        this.dataCreazione = LocalDate.now();
        this.emailAziendale = emailAziendale;
        this.giornoInizio = giornoInizio;
        this.giornoFine = giornoFine;
        this.motivazione = motivazione;
        this.stato = StatoRichiesta.IN_ATTESA;
        this.motivazioneRifiuto = null;

    }

    public void accettaRichiesta() {
        this.stato = StatoRichiesta.ACCETTATA;
        this.dataModifica = LocalDate.now();

    }

    public void rifiutaRichiesta(String motivazione) {
        this.stato = StatoRichiesta.RIFIUTATA;
        this.motivazioneRifiuto = motivazione;
        this.dataModifica = LocalDate.now();
    }
}
