package entities;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager entityManager;

    //ho creato il costruttore che passo nel main, eventodao mi permetterà di manipolare i dati del db
    // cioè sto dicendo a EVENTODAO che per poter fare il suo lavoro col db
    //deve usare l'entitymanager che gli ho passato io nel main quando ho creato l'oggetto new eventodao.
    public EventoDAO(EntityManager entityManager) {
        this.entityManager=entityManager;


    }

    //metodo per salvare un evento
    public void salvaEvento(Eventi newEvento){

        //Passaggi
        //Per modificare il db serve una transazione obbligatoria, quindi come prima cosa la devo creare
        EntityTransaction transaction= this.entityManager.getTransaction();

        // ora faccio partire la transazione
        transaction.begin();

        //ora devo fare in modo che oggetto evento diventi managed e quindi controllato da entity manager
        //lo devo includere nella persistence

        this.entityManager.persist(newEvento);
        //per far in modo che la mia modifica ha funzionato devo fare il commit della transazione

        transaction.commit();

        //messaggio di commit corretto
        System.out.println("Evento salvato con sucesso nel dataBase!" + " " +  newEvento);
    }

    //metodo findyById

    public Eventi findById(long idEvento){
        Eventi evento= this.entityManager.find(Eventi.class, idEvento);

        System.out.println("Evento salvato con successo nel dataBase!" + evento);
        return  evento;
    }


}
