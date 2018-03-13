package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import advance.entities.Student;

public class NamedQueryExample {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Student> query = em.createNamedQuery("getAllStudents",Student.class);
		List<Student> list = query.getResultList();
		for(Student s:list){
			System.out.println(s);
		}
		
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
}
