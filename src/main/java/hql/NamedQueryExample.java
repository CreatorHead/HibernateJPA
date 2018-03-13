package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import advance.entities.Student;
import config.HibernateUtils;

public class NamedQueryExample {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query<Student> query = session.getNamedQuery("getAllStudents");
		List<Student> list = query.list();
		
		for(Student s:list){
			System.out.println(s);
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
