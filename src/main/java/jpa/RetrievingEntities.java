package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.test.entities.entity_basic_types.Movie_BasicValueType;

public class RetrievingEntities {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			
			Movie_BasicValueType movie = em.find(Movie_BasicValueType.class, 1);//like get() method in Hibernate
			
			Movie_BasicValueType movie2 = em.getReference(Movie_BasicValueType.class, 2);//like load() method in Hibernate
			System.out.println(movie.getName());
			System.out.println(movie2.getName());
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
		
		
		
		
	}
}
