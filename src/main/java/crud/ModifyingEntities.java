package crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import config.HibernateUtils;

public class ModifyingEntities {
	public static void main(String[] args) {
		Session session = null;
		try {

			session = HibernateUtils.getSessionFactory().openSession();
			session.getTransaction().begin();

			Pen p = session.get(Pen.class, 3);
			System.out.println(p);
			
			/*
			 * It will automatically updated by Hibernate
			 * Until it's in a transaction.
			 */
			p.setColor("pink");
			System.out.println(p);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
