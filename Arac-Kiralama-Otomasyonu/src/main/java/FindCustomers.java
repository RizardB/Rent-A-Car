import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.internal.SessionCreationOptions;

public class FindCustomers {

	public List getCustomers() {
			
			Session session = HibernateUtilCustomer.getSessionFactory().openSession();
			
			List < Customer > customer;
			
			String getCustomerList = "from Customer";
			
			Query query = session.createQuery(getCustomerList);
			
			customer = ((org.hibernate.query.Query<Customer>) query).list();
			
			return customer;
				
	}
	
	
	public List getCustomersTc() {
		
		Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		List < Customer > customer;
		
		String getCustomerList = "select customer_tc from Customer";
		
		Query query = session.createQuery(getCustomerList);
		
		customer = ((org.hibernate.query.Query<Customer>) query).list();
		
		return customer;
			
	}
	public List searchTcCustomerResults(String customerTc) {
		
		Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		List <Customer> customer;
		
		String searchTcCustomer = "from Customer where customer_tc like : customerTc";
		
		Query query = session.createQuery(searchTcCustomer);
		
		query.setParameter("customerTc", "%" + customerTc + "%");
		
		customer = query.getResultList();
		
		return customer;
		
	}
	
	public List searchEmailCustomerResults(String customerEmail) {
			
			Session session = HibernateUtilCustomer.getSessionFactory().openSession();
			
			List <Customer> customer;
			
			String searchEmailCustomer = "from Customer where customer_email like : customerEmail";
			
			Query query = session.createQuery(searchEmailCustomer);
			
			query.setParameter("customerEmail", "%" + customerEmail + "%");
			
			customer = query.getResultList();
			
			return customer;
			
	}

	public List searchNameCustomerResults(String customerName) {
		
		Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		List <Customer> customer;
		
		String searchNameCustomer = "from Customer where customer_first_name like : customerName or customer_last_name like : customerName";
		
		Query query = session.createQuery(searchNameCustomer);
		
		query.setParameter("customerName",  "%" + customerName + "%" );
		
		customer = query.getResultList();
		
		return customer;
		
	}

}
