package org.example;
import entities.*;
import exception.ErroreSalvataggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

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


// crea evento

           Concerto concerto1=new Concerto(
                   "Milano Summer Festival",
                   stadioSanSiro,
                   LocalDate.of(2026, 7, 15),
                   "Ghali live nel cuore di Milano",
                   TipoEvento.PUBBLICO,
                   15000,
                    GenereConcerto.POP,
                   true
           );

           PartitaCalcio partitaCalcio=new PartitaCalcio(
                   "Partita del Cuore 2026",
                   stadioMaradona,
                   LocalDate.of(2026, 9, 12),
                   "Incontro calcistico di beneficenza tra artisti e campioni dello sport",
                   TipoEvento.PRIVATO,
                   40000,
                   "Nazionale Cantanti",
                   "Campioni dello Sport",
                   "Nazionale Cantanti",
                   3,
                   2
           );

            GaraAtletica garaCentoMetri = new GaraAtletica(
                    "Finale 100m Live",
                    circoMassimo,
                    LocalDate.of(2026, 7, 8),
                    "Gara di velocità con i migliori atleti internazionali",
                    TipoEvento.PUBBLICO,
                    20000,
                    "Tortu, Jacobs, Bolt, Gatlin",
                    "Jacobs"
            );


locationDAO.save(stadioSanSiro);
eventoDAO.salvaEvento(concerto1);
personaDAO.save(persona1);


            System.out.println("-------------------- TEST QUERY JPQL -------------------");
            List<Concerto> concertiInStreaming = eventoDAO.getConcertinStreaming(true);

//  controllo: se la lista non è vuota, la stampo elemento per elemento
            if (concertiInStreaming.isEmpty()) {
                    System.out.println("Nessun concerto in streaming trovato nel Database.");
            } else {
                    System.out.println("Ecco la lista dei concerti in streaming trovati (" + concertiInStreaming.size() + "):");

                    // Ciclo for-each per stampare i dettagli di ogni concerto
                    for (Concerto c : concertiInStreaming) {
                            System.out.println("-> Titolo: " + c.getTitolo() + "Descrizione: " + c.getDescrizione() +" | Genere: " + c.getGenereConcerto() + " | Data: " + c.getDataEvento());
                    }
            }



    }};