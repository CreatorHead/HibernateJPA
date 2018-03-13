package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import advance.entities.Student;

public class PassingParameters {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		//In JPQL the positional parameters starts with 1 and it is appeded by the positional number
		Query query = em.createQuery("FROM Student s where s.regno= ?1 ");
		query.setParameter(1, "3");
		
		List<Student> list = query.getResultList();
		
		for(Student s:list){
			System.out.println(s);
		}
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
