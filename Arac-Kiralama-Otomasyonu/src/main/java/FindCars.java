import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class FindCars {

	public List getAllCars() {
		
		Session session = HibernateUtilCar.getSessionFactory().openSession();
		
		List < Car > car;
		
		String getCars = "from Car";
		
		Query allCars = session.createQuery(getCars);
		
		car = allCars.getResultList();
		
		return car;
		
	}
	
	public List getCarPlate(String carPlate) {
		
		Session session = HibernateUtilCar.getSessionFactory().openSession();
		
		List < Car > car;
		
		String getCars = "from Car where car_plate like : carPlate";
		
		Query allCars = session.createQuery(getCars).setParameter("carPlate", "%" + carPlate + "%");
		
		car = allCars.getResultList();
		
		return car;
	}
	
	
	public List getCarBrand(String carBrand) {
		
		Session session = HibernateUtilCar.getSessionFactory().openSession();
		
		List < Car > car;
		
		String getCarsBrand = "from Car where car_brand like : carBrand";
		
		Query allCars = session.createQuery(getCarsBrand).setParameter("carBrand", "%" + carBrand + "%");
		
		car = allCars.getResultList();
		
		return car;
	}


	public List getCarModel(String carModel) {
	
		Session session = HibernateUtilCar.getSessionFactory().openSession();
		
		List < Car > car;
		
		String getCars = "from Car where car_model like : carModel";
		
		Query allCars = session.createQuery(getCars).setParameter("carModel", "%" + carModel + "%");
		
		car = allCars.getResultList();
		
		return car;
	}
	
	public List getCarAvailable() {
		
		Session session = HibernateUtilCar.getSessionFactory().openSession();
		
		List < Car > car;
		
		boolean carRented = false;
		
		String getCars = "from Car where car_rented =: carRented";
		
		Query allCars = session.createQuery(getCars).setParameter("carRented", carRented);
		
		car = allCars.getResultList();
		
		return car;
	}
	
	public List getCarSetRent(String carPlate) {
		
		Session session = HibernateUtilCar.getSessionFactory().openSession();
		
		List < Car > car;
		
		String getCars = "from Car where car_plate =: carPlate";
		
		Query allCars = session.createQuery(getCars).setParameter("carPlate", carPlate);
		
		car = allCars.getResultList();
		
		return car;
	}
	
	public List getRented() {
		
		Session session = HibernateUtilCar.getSessionFactory().openSession();
		
		List < Car > car;
		
		boolean carRented = true;
		
		String getCars = "from Car where car_rented =: carRented";
		
		Query allCars = session.createQuery(getCars).setParameter("carRented", carRented);
		
		car = allCars.getResultList();
		
		return car;
	}
	
	public List getRentedRentCars() {
		
		Session session = HibernateUtilRent.getSessionFactory().openSession();
		
		List < Car > car;
		
		String getCars = "from Rent";
		
		Query allCars = session.createQuery(getCars);
		
		car = allCars.getResultList();
		
		return car;
	}
		
}
