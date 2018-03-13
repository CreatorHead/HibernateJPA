package advance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import advance.entities.Account;
import advance.entities.AccountType;
import config.HibernateUtils;

public class Enumerations {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		Account account = new Account();
		account.setAccountId(1);
		account.setAccountType(AccountType.SAVINGS);
		
		session.persist(account);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
