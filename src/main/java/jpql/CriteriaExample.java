package jpql;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import advance.entities.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		
		TypedQuery<Student> query = em.createQuery(criteriaQuery);
		List<Student> list = query.getResultList();
		
		em.getTransaction().commit();
		
		for(Student s:list){
			System.out.println(s);
		}
		em.close();
	}
}
