package entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager entityManager;
    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public void save(Partecipazione partecipazione) {
       EntityTransaction transaction = entityManager.getTransaction();
       transaction.begin();
       entityManager.persist(partecipazione);
       transaction.commit();
        System.out.println("Partecipazione inserita nel DB: " + partecipazione);
    }
}
