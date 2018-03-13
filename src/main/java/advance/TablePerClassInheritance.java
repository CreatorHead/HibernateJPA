package advance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.ContractEmployee;
import advance.entities.RegularEmployee;
import config.HibernateUtils;

public class TablePerClassInheritance {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		RegularEmployee r = new RegularEmployee();
		r.setBonus(20.00);
		r.setName("Blake");
		r.setSalary(25000.00);
		
		ContractEmployee c = new ContractEmployee();
		c.setContractDuration("2 Years");
		c.setName("Ryder");
		c.setPayPerHour(20.00);
		
		session.save(r);
		session.save(c);
		
		session.getTransaction().commit();
		session.close();
	}
}
