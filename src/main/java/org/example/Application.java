package org.example;
import entities.*;
import exception.ErroreSalvataggio;
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
LocationDAO locationDAO=new LocationDAO(em);
Partecipazione partecipazione=new Partecipazione();
PersonaDAO personaDAO=new PersonaDAO(em);
//ora creo prima gli eventi

        System.out.println("--------------------SALVATAGGIO IN CORSO-------------------");

Location stadioSanSiro=new Location("San Siro", "Milano");
Persona Emanuela =new Persona("Emanuela", "Carrubba", "emanuela_carrubba_@hotmail.com", LocalDate.of(1998, 8, 25), "F");
        Eventi concerto1 = new Eventi(
                "Milano Summer Festival",
                stadioSanSiro, // <--- Ecco la nostra location passata correttamente
                LocalDate.of(2026, 7, 15),
                "Ghali live nel cuore di Milano",
                TipoEvento.PUBBLICO,
                15000
        );
Partecipazione biglietto1 = new Partecipazione(Emanuela, concerto1, StatoPartecipazione.CONFERMATA);
PartecipazioneDAO partecipazioneDAO=new PartecipazioneDAO(em);

        System.out.println("-------------------- SALVATAGGIO IN CORSO SUL DB -------------------");

        locationDAO.save(stadioSanSiro);
        personaDAO.save(Emanuela);
        eventoDAO.salvaEvento(concerto1);
        partecipazioneDAO.save(biglietto1);

        System.out.println("Salvataggi inviati al DB con successo!");






    }};