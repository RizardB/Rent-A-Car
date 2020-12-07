import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class UpdateCustomer {
	
	public void updateCustomer(String customerTc, String customerFirstName, String customerLastName, String customerBirthdate, String customerGender, 
			String customerPhoneNumber, String customerEmail, String customerJob, String customerLicence, String customerLicenceNo, String customerNotes, String customerAddress) {
		
		/*Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		List < Customer > customer;
		
		String getCustomerList = "update Customer set customer_first_name =: customerFirstName, customer_last_name =: customerLastName, customer_email =: customerEmail,"
				+ " customer_phone =: customerPhoneNumber, customer_address =: customerAddress, "
				+ "customer_gender =: customerGender, customer_job =: customerJob, customer_birthdate =: customerBirthdate, "
				+ "customer_licence =: customerLicence, customer_licence_no =: customerLicenceNo, customer_notes =: customerNotes,"
				+ "where customer_tc =: customerTc";
		
		Query query = session.createQuery(getCustomerList).setParameter("customerTc", customerTc).setParameter("customerFirstName", customerFirstName)
				.setParameter("customerLastName", customerLastName).setParameter("customerBirthdate", customerBirthdate)
				.setParameter("customerGender", customerGender).setParameter("customerPhoneNumber", customerPhoneNumber).setParameter("customerEmail", customerEmail)
				.setParameter("customerEmail", customerEmail).setParameter("customerJob", customerJob).setParameter("customerLicence", customerLicence)
				.setParameter("customerLicenceNo", customerLicenceNo).setParameter("customerNotes", customerNotes).setParameter("customerAddress", customerAddress);
		
		session.update(query);*/
		
		Customer updateCustomer = new Customer();
		
		
		
			
}
	
	public void updateCustomerNow(Customer c) {
		
		Session session = HibernateUtilCustomer.getSessionFactory().openSession();
		
		session.saveOrUpdate(c);
		
		session.getTransaction().commit();
	}

}
