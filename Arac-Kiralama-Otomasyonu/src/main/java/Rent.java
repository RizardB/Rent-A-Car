import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rent")
public class Rent {
	
	@Id
	@Column (name = "car_plate")
	private String carPlate;
	
	@Column (name = "customer_tc")
	private String customerTc;
	
	@Column (name = "customer_email")
	private String customerEmail;
	
	@Column (name = "customer_phone_number")
	private String customerPhoneNumber;
	
	@Column (name = "rent_date")
	private Date rentDate;
	
	@Column (name = "retrieve_date")
	private Date retrieveDate;
	
	@Column (name = "car_price")
	private String carPrice;
	
	public Rent() {
		
	}
	
	public Rent(String customerTc, String customerEmail, String customerPhoneNumber, String carPlate, String carPrice, Date rentDate, Date retrieveDate) {
		this.customerTc=customerTc;
		this.customerEmail=customerEmail;
		this.customerPhoneNumber=customerPhoneNumber;
		this.carPlate=carPlate;
		this.rentDate = rentDate;
		this.retrieveDate = retrieveDate;
		this.carPrice = carPrice;
	}

	public String getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getRetrieveDate() {
		return retrieveDate;
	}

	public void setRetrieveDate(Date retrieveDate) {
		this.retrieveDate = retrieveDate;
	}

	public String getCustomerTc() {
		return customerTc;
	}

	public void setCustomerTc(String customerTc) {
		this.customerTc = customerTc;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}
	
	
}
