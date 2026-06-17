package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

//Creo la classe eventi e definisco tutti i suoi attributi
//2) Attivo Hibernate dicendogli che questa classe creata voglio che diventi una tabella
//lo faccio con @entity e definisco il nome della tabella
//imposto il nullable a false per ogni colonna perchè questi dati mi servono e non possono essere null o vuoti.

@Entity
@Table(name= "Eventi")
public class Eventi {
    //Definisco, quindi la PrimariKey @id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titolo;

    @Column(name= "data_evento",nullable = false)
    private LocalDate dataEvento;

    @Column(nullable = false, length = 100)
    private String descrizione;

    //ho reso required l'enum per la tabella (evento può essere solo di due tipi)
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(name= "max_numero_partecipanti")
    private int numeroMassimoPartecipanti;


    //Molti eventi possono avere la stessa location
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false) //mi riferisco alla location id della tabella eventi.
    private Location location;



    //creo il costruttore della classe, ma non gli passo l'id perchè sarà automaticmanete generato dal DB
    public Eventi( String titolo, Location location, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    //definisco i getter e i setter per la classe

    // Getter necessario per recuperare l'ID autogenerato dal DB all'interno del DAO e del Main
    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }
    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    //  Il tipo di ritorno deve essere l'Enum TipoEvento
    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }


    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
   public Location getLocation() {
        return location;
   }
    public void setLocation( Location location) {
        this.location = location;
    }

    //Istanzio il costruttore vuoto che serve ad hibernate
    public Eventi() {}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Eventi{");
        sb.append("id=").append(id);
        sb.append(", titolo='").append(titolo).append('\'');
        sb.append(", dataEvento=").append(dataEvento);
        sb.append(", descrizione='").append(descrizione).append('\'');
        sb.append(", tipoEvento=").append(tipoEvento);
        sb.append(", numeroMassimoPartecipanti=").append(numeroMassimoPartecipanti);
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }

    //1) dopo aver costruito la classe di base, ora devo "attivare" Hibernate dicendogli che voglio trasformare questa classe in una tabella e aggiungerla al database, quindi ho bisogno che
    //diventi un oggetto MANAGED, ossia osservato dall'Entity Manager in modo che lui riesca ad applicare
    //le modifiche ai dati. Quindi procederò a modificare la classe che avevo creato.
}