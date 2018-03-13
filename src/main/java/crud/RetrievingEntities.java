package crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import config.HibernateUtils;

public class RetrievingEntities {
	public static void main(String[] args) {
		Session session = null;
		try {

			session = HibernateUtils.getSessionFactory().openSession();
			session.getTransaction().begin();

			Pen p = session.get(Pen.class, 1);
			System.out.println(p);
			
			Pen p2 = session.load(Pen.class, 2);
			System.out.println(p2);
			
			Pen p3 = session.get(Pen.class, 1);
			System.out.println(p3);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
