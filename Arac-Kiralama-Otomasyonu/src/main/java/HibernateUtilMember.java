import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtilMember {

	//XML based configuration
	private static SessionFactory sessionFactory;
	
	
	private static SessionFactory newSessionFactory() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Member.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx =  session.beginTransaction();
		
		tx.commit();
		
		return sf;
	}

	public static SessionFactory getSessionFactory() {
		sessionFactory = null;
        if(sessionFactory == null) sessionFactory = newSessionFactory();
        return sessionFactory;
    }
	
}
