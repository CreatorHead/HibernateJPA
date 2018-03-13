package advance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.Currency;
import advance.entities.Market;
import config.HibernateUtils;

public class CompoundJoinColumns {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		Currency currency = new Currency();
		currency.setCountryName("USA");
		currency.setName("American Dollar");
		currency.setSymbol("$");
		
		Market market = new Market();
		market.setCurrency(currency);
		market.setMarketName("Us Stock Exchange");
		
		session.persist(market);
		
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.merge(market);
		session.beginTransaction();
		market = session.get(Market.class,market.getMarketId());
		System.out.println(market.getCurrency().getSymbol());
		session.getTransaction().commit();
		session.close();
	}
}
