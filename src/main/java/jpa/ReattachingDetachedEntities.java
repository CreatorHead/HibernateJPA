package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.test.entities.entity_basic_types.Movie_BasicValueType;

public class ReattachingDetachedEntities {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
			em = emf.createEntityManager();

			tx = em.getTransaction();
			tx.begin();
			
			Movie_BasicValueType movie = em.find(Movie_BasicValueType.class, 2);
			em.clear(); // clear/evict the Persistence Context and Make the movie Entity Detached
//			em.detach(movie); //Detached a Single Entities
			System.out.println(em.contains(movie)); //false
			
			movie.setSummery("Wrong Show");
			Movie_BasicValueType movie2 = em.merge(movie);  //Re-attaching the entity in the Persistence Context
			System.out.println(movie2.getName());
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
