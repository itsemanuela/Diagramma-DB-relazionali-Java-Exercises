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
//locations
Location stadioSanSiro=new Location("San Siro", "Milano");
        Location stadioMaradona = new Location("Stadio Diego Armando Maradona", "Napoli");
        Location circoMassimo = new Location("Circo Massimo", "Roma");

//persone
Persona Emanuela =new Persona("Emanuela", "Carrubba", "emanuela_carrubba_@hotmail.com", LocalDate.of(1998, 8, 25), "F");
        Persona persona1 = new Persona("Luca", "Rossi", "luca.rossi@gmail.com", LocalDate.of(1995, 4, 12), "M");
        Persona persona2 = new Persona("Giulia", "Bianchi", "giulia.bianchi@outlook.it", LocalDate.of(2001, 11, 3), "F");
        Persona persona3 = new Persona("Marco", "Esposito", "marco.esposito99@hotmail.com", LocalDate.of(1999, 1, 25), "M");
        Persona persona4 = new Persona("Sofia", "Ricci", "sofia.ricci@yahoo.com", LocalDate.of(2003, 7, 14), "F");
        Persona persona5 = new Persona("Alessandro", "Ferrari", "a.ferrari@gmail.com", LocalDate.of(1992, 8, 30), "M");




        Eventi concerto1 = new Eventi(
                "Milano Summer Festival",
                stadioSanSiro, // <--- Ecco la nostra location passata correttamente
                LocalDate.of(2026, 7, 15),
                "Ghali live nel cuore di Milano",
                TipoEvento.PUBBLICO,
                15000
        );


        Eventi concertoNapoli = new Eventi(
                "Geolier Live Tour",
                stadioMaradona,
                LocalDate.of(2026, 6, 28),
                "Il re del rap napoletano in concerto nello stadio della sua città",
                TipoEvento.PUBBLICO,
                55000
        );


        Eventi rockInRoma = new Eventi(
                "Rock in Roma - Green Day",
                circoMassimo,
                LocalDate.of(2026, 7, 8),
                "La band punk-rock americana storica fa tappa nella capitale",
                TipoEvento.PUBBLICO,
                70000
        );


        Eventi partitaBeneficenza = new Eventi(
                "Partita del Cuore 2026",
                stadioMaradona,
                LocalDate.of(2026, 9, 12),
                "Incontro calcistico di beneficenza tra artisti e campioni dello sport",
                TipoEvento.PRIVATO,
                40000
        );

        Eventi concertoPop = new Eventi(
                "Lazza Winter Tour",
                stadioSanSiro, // <--- Usiamo lo stadio che hai già creato tu!
                LocalDate.of(2026, 11, 20),
                "Tappa speciale nei palazzetti e stadi per il tour invernale",
                TipoEvento.PUBBLICO,
                60000
        );



Partecipazione biglietto1 = new Partecipazione(Emanuela, concerto1, StatoPartecipazione.CONFERMATA);
PartecipazioneDAO partecipazioneDAO=new PartecipazioneDAO(em);

        System.out.println("-------------------- SALVATAGGIO IN CORSO SUL DB -------------------");

        locationDAO.save(stadioSanSiro);
        personaDAO.save(Emanuela);
        eventoDAO.salvaEvento(concerto1);
        partecipazioneDAO.save(biglietto1);
        locationDAO.save(stadioMaradona);
        locationDAO.save(circoMassimo);
//salva eventi
        eventoDAO.salvaEvento(concertoNapoli);
        eventoDAO.salvaEvento(rockInRoma);
        eventoDAO.salvaEvento(partitaBeneficenza);
        eventoDAO.salvaEvento(concertoPop);

        //salva persone
        personaDAO.save(Emanuela);
        personaDAO.save(persona1);
        personaDAO.save(persona2);
        personaDAO.save(persona3);
        personaDAO.save(persona4);
        personaDAO.save(persona5);


        System.out.println("Salvataggi inviati al DB con successo!");






    }};