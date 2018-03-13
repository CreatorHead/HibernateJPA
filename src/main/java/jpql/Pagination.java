package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import advance.entities.Emp;

public class Pagination {
	public static void main(String[] args) {
		int pageNumber = 3;
		int pageSize = 4;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Emp> criteriaQuery = cb.createQuery(Emp.class);
		Root<Emp> root = criteriaQuery.from(Emp.class);
		criteriaQuery.select(root);
		
		Query query = em.createQuery(criteriaQuery);
		query.setFirstResult((pageNumber - 1)* pageSize);
		query.setMaxResults(pageSize);
		List<Emp> list = query.getResultList();
		for(Emp e:list){
			System.out.println(e);
		}
		em.close();
	}
}
