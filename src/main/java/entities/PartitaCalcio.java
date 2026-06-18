package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="partita_calcio")
public class PartitaCalcio extends Eventi {

    private String squadra_casa;
    private String squadra_ospite;
    private String squadra_vincente;
    private int numero_gol_casa;
    private int numero_gol_ospite;

    public PartitaCalcio() {}

    public PartitaCalcio(
            String titolo, Location location, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti,
            String squadra_casa, String squadra_ospite, String squadra_vincente, int numero_gol_casa, int numero_gol_ospite

    )

    {
        super(titolo,location,  dataEvento, descrizione,  tipoEvento,numeroMassimoPartecipanti);
        this.squadra_casa = squadra_casa;
        this.squadra_ospite = squadra_ospite;
        this.squadra_vincente = squadra_vincente;
        this.numero_gol_casa = numero_gol_casa;
        this.numero_gol_ospite = numero_gol_ospite;


    }


    public String getSquadra_casa() {
        return squadra_casa;
    }
    public void setSquadra_casa(String squadra_casa) {
        this.squadra_casa = squadra_casa;
    }
    public String getSquadra_ospite() {
        return squadra_ospite;
    }
    public void setSquadra_ospite(String squadra_ospite) {
        this.squadra_ospite = squadra_ospite;
    }
    public String getSquadra_vincente() {
        return squadra_vincente;
    }
    public void setSquadra_vincente(String squadra_vincente) {
        this.squadra_vincente = squadra_vincente;
    }
    public int getNumero_gol_casa() {
        return numero_gol_casa;
    }
    public void setNumero_gol_casa(int numero_gol_casa) {
        this.numero_gol_casa = numero_gol_casa;
    }
    public int getNumero_gol_ospite() {
        return numero_gol_ospite;
    }
    public void setNumero_gol_ospite(int numero_gol_ospite) {
        this.numero_gol_ospite = numero_gol_ospite;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PartitaCalcio{");
        sb.append("squadra_casa='").append(squadra_casa).append('\'');
        sb.append(", squadra_ospite='").append(squadra_ospite).append('\'');
        sb.append(", squadra_vincente='").append(squadra_vincente).append('\'');
        sb.append(", numero_gol_casa=").append(numero_gol_casa);
        sb.append(", numero_gol_ospite=").append(numero_gol_ospite);
        sb.append('}');
        return sb.toString();
    }
}
