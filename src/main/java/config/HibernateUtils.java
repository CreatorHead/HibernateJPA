package config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory SESSION_FACTORY = generateSessionFactory();
	
	private static SessionFactory generateSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			return cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Not able to create SessionFactory");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
