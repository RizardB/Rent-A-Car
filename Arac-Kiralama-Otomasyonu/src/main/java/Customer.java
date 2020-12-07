import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column ( name = "customer_tc" )
	private String  customerTc;
	
	@Column ( name = "customer_first_name" )
	private String customerFirstName;
	
	@Column ( name = "customer_last_name" )
	private String customerLastName;
	
	@Column ( name = "customer_email" )
	private String customerEmail;
	
	@Column ( name  = "customer_phone" )
	private String customerPhoneNumber;
	
	@Column ( name = "customer_address" )
	private String customerAddress;
	
	@Column ( name = "customer_gender" )
	private String customerGender;
	
	@Column ( name = "customer_job" )
	private String customerJob;
	
	@Column ( name = "customer_birthdate" )
	private Date customerBirthdate;
	
	@Column ( name = "customer_licence" )
	private String customerLicence;
	
	@Column (name = "customer_licence_no" )
	private String customerLicenceNo;
	
	@Column (name = "customer_notes" )
	private String customerNotes;

	public Customer()
	{
		
	}
	
	public Customer ( String customerTc, String customerFirstName, String customerLastName, String customerEmail, String customerPhoneNumber, String customerAddress, 
			String customerGender, String customerJob, Date customerBirthDate, String customerLicence, String customerLicenceNo, String customerNotes)
	{
		
		this.customerTc = customerTc;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail =  customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerAddress = customerAddress;
		this.customerGender = customerGender;
		this.customerJob = customerJob;
		this.customerBirthdate = customerBirthDate;
		this.customerLicence = customerLicence;
		this.customerLicenceNo = customerLicenceNo;
		this.customerNotes = customerNotes;
		
	}
	
	public Customer(String customerTc, String firstNameText, String lastNameText, String emailText, String phoneNumberText,
			String addressTextArea, String genderText, String jobText, String lincenceText, String lincenceNoText,
			String notesText) {
		
		this.customerTc = customerTc;
		this.customerFirstName = firstNameText;
		this.customerLastName = lastNameText;
		this.customerEmail =  emailText;
		this.customerPhoneNumber = phoneNumberText;
		this.customerAddress = addressTextArea;
		this.customerGender = genderText;
		this.customerJob = jobText;
		this.customerLicence = lincenceText;
		this.customerLicenceNo = lincenceNoText;
		this.customerNotes = notesText;
	}

	public String getcustomerTc() {
		return customerTc;
	}

	public void setcustomerTc(String customerTc) {
		this.customerTc = customerTc;
	}

	public String getcustomerFirstName() {
		return customerFirstName;
	}

	public void setcustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getcustomerLastName() {
		return customerLastName;
	}

	public void setcustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getcustomerEmail() {
		return customerEmail;
	}

	public void setcustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getcustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setcustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getcustomerGender() {
		return customerGender;
	}

	public void setcustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getcustomerJob() {
		return customerJob;
	}

	public void setcustomerJob(String customerJob) {
		this.customerJob = customerJob;
	}

	public Date getcustomerBirthdate() {
		return customerBirthdate;
	}

	public void setcustomerBirthdate(Date customerBirthdate) {
		this.customerBirthdate = customerBirthdate;
	}

	public String getcustomerLicence() {
		return customerLicence;
	}

	public void setcustomerLicence(String customerLincence) {
		this.customerLicence = customerLincence;
	}

	public String getcustomerLicenceNo() {
		return customerLicenceNo;
	}

	public void setcustomerLicenceNo(String customerLincenceNo) {
		this.customerLicenceNo = customerLincenceNo;
	}

	public String getcustomerAddress() {
		return customerAddress;
	}

	public void setcustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getcustomerNotes() {
		return customerNotes;
	}

	public void setcustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

}
