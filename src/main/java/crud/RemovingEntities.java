package crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import config.HibernateUtils;

public class RemovingEntities {
	public static void main(String[] args) {
		Session session = null;
		try {

			session = HibernateUtils.getSessionFactory().openSession();
			session.getTransaction().begin();

			Pen p = session.get(Pen.class, 3);
			
			session.delete(p);
			
			System.out.println("Data Deleted...");
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}

