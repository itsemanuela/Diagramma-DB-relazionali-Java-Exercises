package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="gara_atletica")
public class GaraAtletica extends Eventi{
    private String set_atleti;
    private String vincitore;


    public GaraAtletica() {}

    public GaraAtletica(String titolo, Location location, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti,
                        String set_atleti, String vincitore  ) {
        super(titolo, location,  dataEvento,  descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.set_atleti = set_atleti;
        this.vincitore = vincitore;
    }

    public String getSet_atleti() {
        return set_atleti;
    }
    public void setSet_atleti(String set_atleti) {
        this.set_atleti = set_atleti;
    }
    public String getVincitore() {
        return vincitore;
    }
    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GaraAtletica{");
        sb.append("set_atleti='").append(set_atleti).append('\'');
        sb.append(", vincitore='").append(vincitore).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
