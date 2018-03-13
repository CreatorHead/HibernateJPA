package crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import config.HibernateUtils;

public class SavingEntities {
	public static void main(String[] args) {
		Session session = null;
		try {

			session = HibernateUtils.getSessionFactory().openSession();
			session.getTransaction().begin();

			Pen p = new Pen();
			p.setColor("grey");
			p.setName("Parker");

			session.save(p);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
