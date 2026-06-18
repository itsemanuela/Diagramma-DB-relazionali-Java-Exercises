package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="concerto")
public class Concerto extends Eventi{
GenereConcerto genereConcerto;
boolean in_streaming;

public Concerto(){}

    public Concerto(String titolo, Location location, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti,
                    GenereConcerto genereConcerto, boolean in_streaming) {
    super(titolo, location, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
    this.genereConcerto = genereConcerto;
    this.in_streaming = in_streaming;

    }

public GenereConcerto getGenereConcerto() {
    return genereConcerto;
}

public boolean isInStreaming() {
    return in_streaming;
}
public void setInStreaming(boolean in_streaming) {
    this.in_streaming = in_streaming;
}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Concerto{");
        sb.append("genereConcerto=").append(genereConcerto);
        sb.append(", in_streaming=").append(in_streaming);
        sb.append('}');
        return sb.toString();
    }
}
