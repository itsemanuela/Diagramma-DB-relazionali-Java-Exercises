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
                //ora ho collegato eventodao e sa cosa fare perchè gli ho passao l'EntityM.
                EventoDAO eventoDAO=new EventoDAO(em);
                LocationDAO locationDAO=new LocationDAO(em);
                PartecipazioneDAO partecipazioneDAO=new PartecipazioneDAO(em); // CORRETTO QUI!
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

                // crea concerti
                Concerto concertoLazza = new Concerto(
                        "Lazza Winter Tour",
                        stadioSanSiro,
                        LocalDate.of(2026, 11, 20),
                        "Tappa speciale nei palazzetti e stadi per il tour invernale",
                        TipoEvento.PUBBLICO,
                        60000,
                        GenereConcerto.ROCK,
                        false
                );

                Concerto concertoColdplay = new Concerto(
                        "Coldplay - Spheres Live",
                        stadioMaradona,
                        LocalDate.of(2026, 7, 12),
                        "Spettacolo di luci ed effetti visivi unico al mondo",
                        TipoEvento.PUBBLICO,
                        50000,
                        GenereConcerto.ROCK,
                        true
                );

                Concerto concertoUltimo = new Concerto(
                        "Ultimo Stadi 2026",
                        circoMassimo,
                        LocalDate.of(2026, 6, 30),
                        "La favola continua nella splendida cornice della capitale",
                        TipoEvento.PUBBLICO,
                        65000,
                        GenereConcerto.POP,
                        false
                );

                Concerto concertoMarracash = new Concerto(
                        "Marracash - Marrageddon",
                        stadioSanSiro,
                        LocalDate.of(2026, 9, 18),
                        "Il festival rap più grande d'Italia fa tappa a Milano",
                        TipoEvento.PUBBLICO,
                        75000,
                        GenereConcerto.ROCK,
                        true
                );

                //PARTITE
                PartitaCalcio derbyMilano = new PartitaCalcio(
                        "Inter vs Milan - Campionato",
                        stadioSanSiro,
                        LocalDate.of(2026, 10, 24),
                        "Il big match della Madonnina a San Siro",
                        TipoEvento.PUBBLICO,
                        75000,
                        "Inter",
                        "Milan",
                        "Inter",
                        2,
                        1
                );

                PartitaCalcio napoliJuve = new PartitaCalcio(
                        "Napoli vs Juventus",
                        stadioMaradona,
                        LocalDate.of(2026, 11, 05),
                        "Grande classica del campionato italiano",
                        TipoEvento.PUBBLICO,
                        54000,
                        "Napoli",
                        "Juventus",
                        "Pareggio",
                        2,
                        2
                );

                PartitaCalcio finaleChampions = new PartitaCalcio(
                        "Finale Champions League 2026",
                        stadioSanSiro,
                        LocalDate.of(2026, 5, 30),
                        "L'atto finale della competizione europea più prestigiosa",
                        TipoEvento.PUBBLICO,
                        78000,
                        "Real Madrid",
                        "Manchester City",
                        "Real Madrid",
                        1,
                        0
                );

                //GARE
                GaraAtletica saltoInAlto = new GaraAtletica(
                        "Golden Gala - Salto in Alto",
                        stadioMaradona,
                        LocalDate.of(2026, 6, 5),
                        "Meeting internazionale di atletica leggera",
                        TipoEvento.PUBBLICO,
                        35000,
                        "Tamberi, Barshim, Harrison, Woo",
                        "Tamberi"
                );

                GaraAtletica duecentoMetri = new GaraAtletica(
                        "Meeting Milano - 200m Uomini",
                        stadioSanSiro,
                        LocalDate.of(2026, 9, 3),
                        "Gara di velocità sulla mezza curva",
                        TipoEvento.PUBBLICO,
                        15000,
                        "Lyles, Bednarek, Knighton, Tortu",
                        "Lyles"
                );

                GaraAtletica lancioDelGiavellotto = new GaraAtletica(
                        "Roma Athletica - Giavellotto",
                        circoMassimo,
                        LocalDate.of(2026, 7, 20),
                        "Esibizione e gara di lancio del giavellotto",
                        TipoEvento.PUBBLICO,
                        12000,
                        "Chopra, Vadlejch, Weber, Helander",
                        "Chopra"
                );

                GaraAtletica staffettaQuattroPerCento = new GaraAtletica(
                        "Assoluti d'Italia - Staffetta 4x100",
                        stadioMaradona,
                        LocalDate.of(2026, 10, 10),
                        "Campionato italiano staffette velocità",
                        TipoEvento.PUBBLICO,
                        25000,
                        "Italia A, Italia B, Francia, Gran Bretagna",
                        "Italia A"
                );

                // Grazie al PERSIST, salvo gli eventi principali
                // persisto automaticamente anche le location a loro collegate
                eventoDAO.salvaEvento(concertoLazza);
                eventoDAO.salvaEvento(concertoColdplay);
                eventoDAO.salvaEvento(concertoUltimo);
                eventoDAO.salvaEvento(concertoMarracash);

                eventoDAO.salvaEvento(derbyMilano);
                eventoDAO.salvaEvento(napoliJuve);
                eventoDAO.salvaEvento(finaleChampions);

                eventoDAO.salvaEvento(saltoInAlto);
                eventoDAO.salvaEvento(duecentoMetri);
                eventoDAO.salvaEvento(lancioDelGiavellotto);
                eventoDAO.salvaEvento(staffettaQuattroPerCento);

                //partecipazione status
                Partecipazione partEmanuela = new Partecipazione(Emanuela, concertoColdplay, StatoPartecipazione.CONFERMATA);
                Partecipazione partLuca = new Partecipazione(persona1, derbyMilano, StatoPartecipazione.DA_CONFERMARE);
                Partecipazione partGiulia = new Partecipazione(persona2, concertoLazza, StatoPartecipazione.CONFERMATA);
                Partecipazione partMarco = new Partecipazione(persona3, concertoColdplay, StatoPartecipazione.CONFERMATA);
                Partecipazione partSofia = new Partecipazione(persona4, concertoMarracash, StatoPartecipazione.DA_CONFERMARE);
                Partecipazione partAlessandro = new Partecipazione(persona5, napoliJuve, StatoPartecipazione.CONFERMATA);

                // SALVATAGGIO PARTECIPAZIONI SUL DB
                List.of(
                        partEmanuela, partLuca, partGiulia, partMarco, partSofia, partAlessandro
                ).forEach(partecipazioneDAO::save);

                System.out.println("-------------------- TEST QUERY JPQL -------------------");
                List<Concerto> concertiInStreaming = eventoDAO.getConcertinStreaming(true);

                // controllo: se la lista non è vuota, la stampo elemento per elemento
                if (concertiInStreaming.isEmpty()) {
                        System.out.println("Nessun concerto in streaming trovato nel Database.");
                } else {
                        System.out.println("Ecco la lista dei concerti in streaming trovati (" + concertiInStreaming.size() + "):");

                        // Ciclo for-each per stampare i dettagli di ogni concerto
                        for (Concerto c : concertiInStreaming) {
                                System.out.println("-> Titolo: " + c.getTitolo() + " | Descrizione: " + c.getDescrizione() +" | Genere: " + c.getGenereConcerto() + " | Data: " + c.getDataEvento());
                        }
                }

                //test metodo getConcerto per genere
                System.out.println("-------------------- TEST QUERY JPQL GENERE -------------------");
                // Chiamiamo il nuovo metodo passando l'enum del genere desiderato
                List<Concerto> concertiRock = eventoDAO.getConcertiPerGenere(GenereConcerto.ROCK);

                // controllo e stampa dei risultati
                if (concertiRock.isEmpty()) {
                        System.out.println("Nessun concerto di genere ROCK trovato nel Database.");
                } else {
                        System.out.println("Ecco la lista dei concerti ROCK trovati (" + concertiRock.size() + "):");

                        for (Concerto c : concertiRock) {
                                System.out.println("-> Titolo: " + c.getTitolo() + " | Descrizione: " + c.getDescrizione() + " | Genere: " + c.getGenereConcerto());
                        }
                }

                // chiudo
                em.close();
                entityManagerFactory.close();
        }
}