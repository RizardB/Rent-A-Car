
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class AuthPersonal {

	public boolean findPersonal (String personalTc, String personalPassword) {
		boolean isValidPersonal = false;
		
		Session session = HibernateUtilPersonal.getSessionFactory().openSession();
		List < Personal > personal;
		
		String selectPersonalAuthentication = "from Personal where personal_tc = : personalTc and personal_password = : personalPassword";
		
		Query query = session.createQuery(selectPersonalAuthentication );
		
		query.setParameter("personalTc", personalTc);
		query.setParameter("personalPassword", personalPassword);
		
		
		personal = ((org.hibernate.query.Query<Personal>) query).list();
		
		try {
			if ( personal.size()>0 && personal != null) {
				isValidPersonal = true;
			}
		}
		catch (Exception e) {
			isValidPersonal = false;
			e.printStackTrace();
		}
		return isValidPersonal;
	}
	
	public boolean findPersonalTc(String personalTc) {
		boolean isAlreadyTc = false;
		Session session = HibernateUtilPersonal.getSessionFactory().openSession();
		List < Personal > personal;
		
		String selectPersonalTc = "from Personal where personal_tc = : personalTc";
		
		Query query = session.createQuery(selectPersonalTc);
		
		query.setParameter("personalTc", personalTc);
		
		
		personal = ((org.hibernate.query.Query<Personal>) query).list();
		
		
		try {
			if ( personal.size()>0 && personal != null) {
				isAlreadyTc = true;
			}
		}
		catch (Exception e) {
			isAlreadyTc = false;
			e.printStackTrace();
		}
		return isAlreadyTc;
	}
	
	public boolean findPersonalEmail(String personalEmail) {
		boolean isAlreadyEmail = false;
		Session session = HibernateUtilPersonal.getSessionFactory().openSession();
		List < Personal > personal;
		
		String selectPersonalEmail = "from Personal where personal_email = : personalEmail";
		
		Query query = session.createQuery(selectPersonalEmail);
		
		query.setParameter("personalEmail", personalEmail);
		
		
		personal = ((org.hibernate.query.Query<Personal>) query).list();
		try {
			if ( personal.size()>0 && personal != null) {
				isAlreadyEmail = true;
			}
		}
		catch (Exception e) {
			isAlreadyEmail = false;
			e.printStackTrace();
		}
		return isAlreadyEmail;
	}
	
	public boolean findPersonalPhoneNumber(String personalNumber) {
		boolean isAlreadyPhoneNumbr = false;
		Session session = HibernateUtilPersonal.getSessionFactory().openSession();
		List < Personal > personal;
		
		String selectPersonalNumber = "from Personal where personal_phone_number = : personalNumber";
		
		Query query = session.createQuery(selectPersonalNumber);
		
		query.setParameter("personalNumber", personalNumber);
		
		
		personal = ((org.hibernate.query.Query<Personal>) query).list();
		try {
			if ( personal.size()>0 && personal != null) {
				isAlreadyPhoneNumbr = true;
			}
		}
		catch (Exception e) {
			isAlreadyPhoneNumbr = false;
			e.printStackTrace();
		}
		return isAlreadyPhoneNumbr;
	}
	
	public String findPersonalForgotPassword(String personalTc, String personalEmail, String personalPhoneNumber) {
		
		 String forgotPass="";
		
		Session session = HibernateUtilPersonal.getSessionFactory().openSession();
		
		List <Personal> forgotPersonal;
		
		String forgotPassPersonalQuery = "from Personal where personal_tc =: personalTc and personal_email =: personalEmail"
				+ " and personal_phone_number =: personalPhoneNumber";
		Query query = session.createQuery(forgotPassPersonalQuery).setParameter("personalTc", personalTc)
				.setParameter("personalEmail", personalEmail).setParameter("personalPhoneNumber", personalPhoneNumber);
		
		forgotPersonal = query.getResultList();
		
		for (Iterator iterator = forgotPersonal.iterator(); iterator.hasNext();){
			
            Personal personal = (Personal) iterator.next();
            
            forgotPass = personal.getPassword();
            
		}
		
		return forgotPass;
		
	}
	
}
