package hql;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.type.DoubleType;

import advance.entities.Emp;
import config.HibernateUtils;

public class RestrictionsExample {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();
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

		Query<Emp> query = session.createQuery(criteriaQuery);
		List<Emp> list = query.getResultList();
		System.out.println("show: "+list.size());
		
		for(Emp e:list){
			System.out.println(e);
		}
		
		System.out.println("End");
		session.getTransaction().commit();
		session.close();
		System.exit(0);
	}
}
