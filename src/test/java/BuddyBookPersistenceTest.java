
import app.BuddyInfo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BuddyBookPersistenceTest {
        public void performJPA() {
            BuddyInfo first = new BuddyInfo("Nnamdi", "6139998888");
            BuddyInfo second = new BuddyInfo("Anthony", "6132345678");

            // Connecting to the database through EntityManagerFactory
            // connection details loaded from persistence.xml
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactBook");
            EntityManager em = emf.createEntityManager();

            // Creating a new transaction
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // Persisting the product entity objects
            em.persist(first);
            em.persist(second);
            tx.commit();

            // Querying the contents of the database using JPQL query
            Query q = em.createQuery("SELECT p FROM app.BuddyInfo p");
            @SuppressWarnings("unchecked")
            List<BuddyInfo> results = q.getResultList();
            System.out.println("List of BuddyInfos\n----------------");

            for (BuddyInfo p : results) {
                System.out.println(p.getName());
            }
            // Closing connection
            em.close();
            emf.close();
        }
}
