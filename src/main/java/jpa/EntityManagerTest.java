package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.test.entities.entity_basic_types.Movie_BasicValueType;

public class EntityManagerTest {
	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
			em = emf.createEntityManager();

			tx = em.getTransaction();
			tx.begin();

			Movie_BasicValueType movie = new Movie_BasicValueType();

			movie.setId(2);
			movie.setName("Superman");
			movie.setRatings(7);
			movie.setSummery("A Movie");
			
			em.persist(movie);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
