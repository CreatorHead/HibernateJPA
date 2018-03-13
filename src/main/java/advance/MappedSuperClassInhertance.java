package advance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.Cat;
import advance.entities.Dog;
import config.HibernateUtils;

public class MappedSuperClassInhertance {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Dog d = new Dog();
		d.setColor("black");
		d.setName("Smokey");
		d.setDogId(1);
		d.setOwnerName("Blake");
		
		Cat c = new Cat();
		c.setCatId(1);
		c.setColor("White");
		c.setName("ginnie");
		c.setStaffName("Blake");
		
		session.save(d);
		session.save(c);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
