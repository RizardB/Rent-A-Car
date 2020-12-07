
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class AuthMember {

	public boolean findMemberTc(String memberTc) {
		boolean isAlreadyTc = false;
		Session session = HibernateUtilMember.getSessionFactory().openSession();
		List < Member > member;
		
		String selectMemberTc = "from Member where member_tc = : memberTc";
		
		Query query = session.createQuery(selectMemberTc);
		
		query.setParameter("memberTc", memberTc);
		
		
		member = ((org.hibernate.query.Query< Member >) query).list();
		
		
		try {
			if ( member.size()>0 && member != null) {
				isAlreadyTc = true;
			}
		}
		catch (Exception e) {
			isAlreadyTc = false;
			e.printStackTrace();
		}
		return isAlreadyTc;
	}
	
	public boolean findMemberEmail(String memberEmail) {
		boolean isAlreadyEmail = false;
		Session session = HibernateUtilMember.getSessionFactory().openSession();
		List < Member > member;
		
		String selectMemberEmail = "from Member where member_email = : memberEmail";
		
		Query query = session.createQuery(selectMemberEmail);
		
		query.setParameter("memberEmail", memberEmail);
		
		
		member = ((org.hibernate.query.Query< Member >) query).list();
		try {
			if ( member.size()>0 && member != null) {
				isAlreadyEmail = true;
			}
		}
		catch (Exception e) {
			isAlreadyEmail = false;
			e.printStackTrace();
		}
		return isAlreadyEmail;
	}
	
	public boolean findMemberPhoneNumber(String memberNumber) {
		boolean isAlreadyPhoneNumber = false;
		Session session = HibernateUtilMember.getSessionFactory().openSession();
		List < Member > member;
		
		String selectMemberNumber = "from Member where personal_phone_number = : memberNumber";
		
		Query query = session.createQuery(selectMemberNumber);
		
		query.setParameter("memberNumber", memberNumber);
		
		
		member = ((org.hibernate.query.Query< Member >) query).list();
		
		try {
			if ( member.size()>0 && member != null) {
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
