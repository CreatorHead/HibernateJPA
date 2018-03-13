package hql;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import advance.entities.Student;
import config.HibernateUtils;

public class PassingParameters {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		//Indexed Parameter Type
//		Query<Student> query = session.createQuery("FROM Student s WHERE s.regno=?",Student.class);
		
		//Named Parameter Type
		Query<Student> query = session.createQuery("FROM Student s WHERE s.regno= :amount ",Student.class);
//		query.setParameter(0, args[0]); // for Indexed Parameter type
		query.setParameter("amount", args[0]);
		/*
		 * SetParameter can set the type of value intelligently but you should be aware of 
		 * using Temporal type like date and time. You have to explicitly setDate or setTime
		 */
		List<Student> students = query.list();
		for(Student s:students){
			System.out.println(s);
		}
		session.getTransaction().commit();
		session.close();
	}
}
