package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "partecipazioni")

public class Partecipazione {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    //qua collego verso più partecipazioni a una persona, quindi rapporto ManyToOne e gli passo oggetto persona

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "persona_id", nullable = false)
    //praticamente sto dicendo a db di creare il collegamento tra tabella persona e tabella partecipazione
    private Persona persona;

//anche evento ha un rapporto manyToOne e grazie alla tabella di giunzione si collega a persona perchè
    //una persona puo partecipare a piu eventi
    @ManyToOne
    @JoinColumn(name = "evento_id",  nullable = false)
    private Eventi evento;


    @Enumerated(EnumType.STRING)
    @Column(name = "stato_partecipazione",  nullable = false)
    private StatoPartecipazione statoPartecipazione;


    public Partecipazione(){};

  public Partecipazione(Persona persona, Eventi evento,  StatoPartecipazione statoPartecipazione){
      this.persona = persona;
      this.evento = evento;
      this.statoPartecipazione = statoPartecipazione;

  }

public void  setId(long id){
    this.id = id;
  }
public long getId(){
    return this.id;

  }
  public Persona getPersona() {
      return persona;
  }
  public void setPersona(Persona persona) {
      this.persona = persona;
  }
  public Eventi getEvento() {
      return evento;
  }
  public void setEvento(Eventi evento) {
      this.evento = evento;
  }
  public StatoPartecipazione getStatoPartecipazione() {
      return statoPartecipazione;
  }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Partecipazione{");
        sb.append("id=").append(id);
        sb.append(", persona=").append(persona);
        sb.append(", evento=").append(evento);
        sb.append(", statoPartecipazione=").append(statoPartecipazione);
        sb.append('}');
        return sb.toString();
    }
}
