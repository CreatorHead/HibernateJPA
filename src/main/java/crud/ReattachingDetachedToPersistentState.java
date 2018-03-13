package crud;

import org.hibernate.Session;

import config.HibernateUtils;

public class ReattachingDetachedToPersistentState {
	public static void main(String[] args) {
		Session session = null;

		session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		Pen p = session.get(Pen.class, 5);
		session.getTransaction().commit();
		session.close();

		Session session2 = HibernateUtils.getSessionFactory().openSession();
		session2.beginTransaction();
		session2.update(p);
		p.setColor("Dark Blue");
		session2.getTransaction().commit();
		session2.close();
	}
}
