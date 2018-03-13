package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import advance.entities.Student;

public class WritingQueries {
	public static void main(String[] args) {
		EntityManagerFactory factoryManager = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = factoryManager.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
//		Query query = em.createQuery("from Student s order by s.regno");
		TypedQuery<Student> query = em.createQuery("from Student s order by s.regno",Student.class);
		
		List<Student> students = (List<Student>)query.getResultList();
		for(Student s:students){
			System.out.println(s);
		}
		
		tx.commit();
		em.close();
		factoryManager.close();
	}
}
