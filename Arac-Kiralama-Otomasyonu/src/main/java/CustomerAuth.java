
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class CustomerAuth {
	
	public boolean findCustomerTc(String customerTc) {
		
		boolean isAlreadyTc = false;
		
		Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		List < Customer > customer;
		
		String selectPersonalTc = "from Customer where customer_tc = : customerTc";
		
		Query query = session.createQuery(selectPersonalTc);
		
		query.setParameter("customerTc", customerTc);
		
		
		customer = ((org.hibernate.query.Query<Customer>) query).list();
		
		
		try {
			if ( customer.size()>0 && customer != null) {
				isAlreadyTc = true;
			}
		}
		catch (Exception e) {
			isAlreadyTc = false;
			e.printStackTrace();
		}
		return isAlreadyTc;
	}
	
	public boolean findCustomerEmail(String customerEmail) {
		
		boolean isAlreadyEmail = false;
		
		Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		List < Customer > customer;
		
		String selectPersonalEmail = "from Customer where customer_email = : customerEmail";
		
		Query query = session.createQuery(selectPersonalEmail);
		
		query.setParameter("customerEmail", customerEmail);
		
		
		customer = ((org.hibernate.query.Query<Customer>) query).list();
		
		try {
			if ( customer.size()>0 && customer != null) {
				isAlreadyEmail = true;
			}
		}
		catch (Exception e) {
			isAlreadyEmail = false;
			e.printStackTrace();
		}
		return isAlreadyEmail;
	}
	
	public boolean findCustomerPhoneNumber(String customerPhoneNumber) {
		
		boolean isAlreadyPhoneNumber = false;
		
		Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		List < Customer > customer;
		
		String selectCustomerNumber = "from Customer where customer_phone = : customerPhoneNumber";
		
		Query query = session.createQuery(selectCustomerNumber);
		
		query.setParameter("customerPhoneNumber", customerPhoneNumber);
		
		
		customer = ((org.hibernate.query.Query<Customer>) query).list();
		
		try {
			if ( customer.size()>0 && customer != null) {
				isAlreadyPhoneNumber = true;
			}
		}
		catch (Exception e) {
			isAlreadyPhoneNumber = false;
			e.printStackTrace();
		}
		return isAlreadyPhoneNumber;
	}
	
}
