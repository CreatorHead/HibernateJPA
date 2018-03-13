package hql;


import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.Student;
import config.HibernateUtils;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		
		TypedQuery<Student> query = session.createQuery(criteriaQuery);
		List<Student> list = query.getResultList();
		
		for(Student s:list){
			System.out.println(s);
		}
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
