package hql;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.Emp;
import config.HibernateUtils;

public class Pagination {
	public static void main(String[] args) {
		int pageNumber = 3;
		int pageSize = 4;
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Emp> criteriaQuery = cb.createQuery(Emp.class);
		Root<Emp> root = criteriaQuery.from(Emp.class);
		criteriaQuery.select(root);
		
		Query query = session.createQuery(criteriaQuery);
		query.setFirstResult((pageNumber - 1)* pageSize);
		query.setMaxResults(pageSize);
		List<Emp> list = query.getResultList();
		for(Emp e:list){
			System.out.println(e);
		}
		session.getTransaction().commit();
		session.close();
	}
}
