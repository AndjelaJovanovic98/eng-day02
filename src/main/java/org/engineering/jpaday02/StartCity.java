package org.engineering.jpaday02;

import javax.persistence.Persistence;

import org.engineering.jpaday02task.entity.City;
import org.engineering.jpaday02task.service.CityService;

public class StartCity {
	
	private  CityService cityService;
	
	public StartCity() {
		cityService = new CityService(Persistence.createEntityManagerFactory("JPADay02Task"));
	}

	public static void main(String[] args) {
		StartCity startCity = new StartCity();
		
		startCity.save(11000, "Beograd");

	}
	
	private void save(int pibNumber, String name) {
		City city = new City();
		city.setPib_number(11000);
		city.setName("Beograd");
		
		try {
			city = cityService.save(city);
			System.out.println("Grad je sacuvan");
		} catch (Exception e) {
			System.out.println("Main: greska -> " + e.getMessage());
		}
	}

}
