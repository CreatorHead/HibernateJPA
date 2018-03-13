package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import advance.entities.Emp;
import config.HibernateUtils;

public class RestrictionsExample {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Emp> criteriaQuery = builder.createQuery(Emp.class);

		Root<Emp> root = criteriaQuery.from(Emp.class);
		Path<Double> sal = root.get("sal");
		Path<String> job = root.get("job");


		criteriaQuery.select(root)
					 .where(builder.and(
							 				builder.equal(job, "SALESMAN"),
							 				builder.le(sal,new Double(2000.0))
							 			)
							);

		TypedQuery<Emp> query = em.createQuery(criteriaQuery);
		List<Emp> list = query.getResultList();
		System.out.println("show: "+list.size());
		em.getTransaction().commit();
		for(Emp e:list){
			System.out.println(e);
		}
		
		System.out.println("End");
		System.exit(0);
	}
}
