package entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private EntityManager entityManager;
    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    public void save(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(persona);
        transaction.commit();
        System.out.println("Persona inserita nel DB" + " " + persona);

    }};
