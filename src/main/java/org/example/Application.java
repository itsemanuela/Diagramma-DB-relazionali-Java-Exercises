package org.example;
import entities.Eventi;
import entities.EventoDAO;
import entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    //nel main mi apro e do' il via alle operazioni che deve fare Entity Manager
    //Prelevo dal persistence il l'unitname di riferimento per il DB
    private static final EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("progetto-jpa");

    public static void main(String[] args) {
        //
EntityManager em=entityManagerFactory.createEntityManager();

//creo oggetto new dao e gli passo l'entitymanager

       EventoDAO eventoDAO=new EventoDAO(em);  //ora ho collegato eventodao e sa cosa fare perchè gli ho passao l'EntityM.

//ora creo prima gli eventi

        Eventi concertoG=new Eventi(
                "Milano Summer Festival",
                LocalDate.of(2026, 7, 15),
                "Ghali live nel cuore di Milano",
                TipoEvento.PUBBLICO,
                15000
        );

        Eventi congresso2= new Eventi(
                "Java Tech Conference",
                LocalDate.of(2026, 9, 22),
                "Conferenza annuale sulle novità di Hibernate",
                TipoEvento.PUBBLICO,
                350
        );

        Eventi gala3= new Eventi(
                "Gala Aziendale Private",
                LocalDate.of(2026, 12, 18),
                "Cena di gala riservata esclusivamente ai dipendenti",
                TipoEvento.PRIVATO,
                120
        );
        System.out.println("----------------SALVATAGGIO IN CORSO------------------");


        //ora richiamo il metodo per salvare i dati con un controllo

        try{
            eventoDAO.salvaEvento(concertoG);
            eventoDAO.salvaEvento(congresso2);
            eventoDAO.salvaEvento(gala3);
            System.out.println("Salvataggio eseguito con successo!");
        } catch (Exception e){
            System.out.println("Impossibile eseguire il salvataggio");
        }
        //findbyid
        try{
            System.out.println("------------RICERCA IN CORSO------------");
            Eventi eventoTrovato= eventoDAO.findById(1);
            if(eventoTrovato!=null){
                System.out.println("Evento trovato con successo" + " " +eventoTrovato.toString());
            } else {
                System.out.println("Evento trovato non trovato");
            }
        } catch(Exception e){
            System.out.println("Impossibile eseguire il salvataggio");
        }


    }


}