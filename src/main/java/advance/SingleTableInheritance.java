package advance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.Circle;
import advance.entities.Rectangle;
import advance.entities.Shape;
import config.HibernateUtils;

public class SingleTableInheritance {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Rectangle r = new Rectangle();
		r.setBreadth(2);
		r.setLength(5);
		r.setColor("Black");
		
		Circle c = new Circle();
		c.setColor("White");
		c.setRadius(5);
		
		Shape s = new Shape();
		s.setColor("Blue");
		
		session.save(s);
		session.save(r);
		session.save(c);
		
		session.getTransaction().commit();
		session.close();
	}
}
