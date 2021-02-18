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
		
		startCity.save(11070, "Novi Beograd");

	}
	
	private void save(int pibNumber, String name) {
		City city = new City();
		city.setPib_number(pibNumber);
		city.setName(name);
		
		try {
			city = cityService.save(city);
			System.out.println("Grad je sacuvan");
		} catch (Exception e) {
			System.out.println("Main: greska -> " + e.getMessage());
		}
	}
	
	//save sa predavanja:
	
	private void citySaveOrUpdate() {
		City city = new City();
		city.setId(null);
		city.setPib_number(11030);
		city.setName("Rakovica");
		try {
			city = cityService.saveOrUpdate(city);
			System.out.println(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
