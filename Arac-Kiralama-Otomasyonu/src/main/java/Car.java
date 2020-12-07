import java.sql.Blob;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car {

	@Id
	@Column (name = "car_plate")
	private String plate;
	
	@Column (name = "car_brand")
	private String brand;
	
	@Column (name = "car_model")
	private String model;
	
	@Column (name = "car_year")
	private int year;
	
	@Column (name = "car_fuel")
	private String fuel;
	
	@Column (name = "car_gear")
	private String gear;
	
	@Column (name = "car_engine")
	private String engine;
	
	@Column (name = "car_traction")
	private String traction;
	
	@Column (name = "car_door")
	private String door;
	
	@Column (name = "car_color")
	private String color;
	
	@Column (name = "car_km")
	private String km;
	
	@Column (name = "car_body")
	private String body;
	
	@Column (name = "car_damage_status")
	private String damageStatus;
	
	@Column (name = "car_picture")
	private Blob picture;
	
	@Column (name = "car_rented")
	private boolean rented;
	
	@Column (name = "car_price_per_day")
	private int pricePerDay;
	

	public Car () {
		
	}
	
	public Car (String plate, String brand, String model, int year, String fuel, String gear, 
			String engine, String traction, String door, String color, String km, String body, String damageStatus, Blob picture, boolean rented, int pricePerDay) {
		this.plate = plate;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.fuel = fuel;
		this.gear = gear;
		this.engine = engine;
		this.door=door;
		this.traction = traction;
		this.color = color;
		this.km = km;
		this.body = body;
		this.damageStatus = damageStatus;
		this.picture=picture;
		this.rented=rented;
		this.pricePerDay=pricePerDay;
	}
	
	public Car(String plate, String brand, String model, int year, String fuel, String gear, 
			String engine, String traction, String door, String color, String km, String body, String damageStatus, Blob picture, int pricePerDay) {
		
		this.plate = plate;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.fuel = fuel;
		this.gear = gear;
		this.engine = engine;
		this.door=door;
		this.traction = traction;
		this.color = color;
		this.km = km;
		this.body = body;
		this.damageStatus = damageStatus;
		this.picture=picture;
		this.pricePerDay=pricePerDay;
		
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getTraction() {
		return traction;
	}

	public void setTraction(String traction) {
		this.traction = traction;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDamageStatus() {
		return damageStatus;
	}

	public void setDamageStatus(String damageStatus) {
		this.damageStatus = damageStatus;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	
	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}
	
	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
		
}
