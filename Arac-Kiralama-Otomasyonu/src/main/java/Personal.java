import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {

	@Id
	@Column (name = "personal_tc")
	private String tc;
	
	@Column (name = "personal_password")
	private String password;
	
	@Column (name = "personal_first_name")
	private String firstName;
	
	@Column (name = "personal_last_name")
	private String lastName;
	
	@Column (name = "personal_email")
	private String email;
	
	@Column (name = "personal_phone_number")
	private String phoneNumber;
	
	@Column (name = "personal_gender")
	private String gender;
	
	@Column (name = "personal_address")
	private String address;
	
	@Column (name = "personal_date_of_birth")
	private Date birthDate;
	
	
	public Personal () {
		
	}
	
	public Personal (String tc, String password, String firstName, String lastName, String email, String phoneNumber, String address, Date birthDate, String gender) {
		this.tc = tc;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.gender = gender;
	}
	
	public String getTc() {
		return tc;
	}
	
	public void setTc(String tc) {
		this.tc=tc;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
		
}
