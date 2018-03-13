package advance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.Currency;
import advance.entities.CurrencyId;
import config.HibernateUtils;

public class CompositeKeys {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Currency currency = null;
		
//		currency = new Currency();
//		currency.setCountryName("India");
//		currency.setName("Rupee");
//		currency.setSymbol("r");
//		
//		session.save(currency);
		
		session.getTransaction().commit();
		
		session.close();
		
		session = factory.openSession();
		
		session.beginTransaction();
		
		currency = session.get(Currency.class, new CurrencyId("Rupee", "India"));
		
		System.out.println(currency.getName());
		
		session.getTransaction().commit();
		session.close();
	}
}
