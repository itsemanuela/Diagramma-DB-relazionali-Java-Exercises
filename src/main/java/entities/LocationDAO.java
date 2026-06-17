package entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager entityManager;
    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;


    }
    //metodo per inserire una location
    public void save(Location location) {
     EntityTransaction transaction = entityManager.getTransaction();
     transaction.begin();
     entityManager.persist(location);
     transaction.commit();
        System.out.println("Location saved" + " " +  location);

    }
    public void update(Location location) {
       EntityTransaction transaction = entityManager.getTransaction();
       transaction.begin();
       entityManager.merge(location);
       transaction.commit();
       System.out.println("Location aggiornata" + " " +  location);
    }

}
