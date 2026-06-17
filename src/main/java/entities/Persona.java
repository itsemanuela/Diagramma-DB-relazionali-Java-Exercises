package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //PK
    private String nome;
    private String cognome;
    private String email;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    private String sesso;


    //lista partecipazioni, considerato il diagramma ha un rapporto One To Many
    //perchè una persona può partecipare a piu eventi
    // quindi devo istanziare OneToMany
    @OneToMany(mappedBy = "persona_id") //fa riferimento a persona_id nella classe Partecipazione
    private List<Partecipazione> listaPartecipazioni;



    public Persona(){};

    public Persona(String nome, String cognome, String email, LocalDate dataNascita, String sesso ) {
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.dataNascita=dataNascita;
        this.sesso=sesso;

    }

    public void getId(){
        this.id=this.id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;

    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
public LocalDate getDataNascita() {
        return dataNascita;
}
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getSesso() {
        return sesso;
    }
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", cognome='").append(cognome).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", dataNascita=").append(dataNascita);
        sb.append(", sesso='").append(sesso).append('\'');
        sb.append(", listaPartecipazioni=").append(listaPartecipazioni);
        sb.append('}');
        return sb.toString();
    }
}
