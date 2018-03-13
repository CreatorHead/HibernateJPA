package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import advance.entities.Student;
import config.HibernateUtils;

public class WritingQueries {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
//		Query<Student> query = session.createQuery("select s from Student s",Student.class);
		Query<Student> query = session.createQuery("from Student",Student.class);
		
		List<Student> students = query.list();
		
		for(Student s:students){
			System.out.println(s);
		}
		session.getTransaction().commit();
		session.close();
	}
}
