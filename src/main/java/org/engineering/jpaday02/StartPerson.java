package org.engineering.jpaday02;

import java.util.List;

import javax.persistence.Persistence;

import org.engineering.jpaday02task.entity.City;
import org.engineering.jpaday02task.entity.Person;
import org.engineering.jpaday02task.service.PersonService;

public class StartPerson {

	private  PersonService personService;
	
	public StartPerson() {
		personService = new PersonService(Persistence.createEntityManagerFactory("JPADay02Task"));
	}
	
	public static void main(String[] args) {
		StartPerson startPerson = new StartPerson();
		//startPerson.save(112587, "Test", "Test", 1, "Beograd");
		//startPerson.findAllPersons();
		
		//startPerson.save("11000", "Test", "Test", 1);
	//	startPerson.findPersonByCity(1);
		startPerson.save("0906998757028", "Andjela", "Jovanovic", 3);

	}
	


	private void save(String pid, String firstName, String lastName, long cityNumber) {
		City city = new City(cityNumber);
		Person person = new Person();
		
		person.setPid(pid);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setCity(city);
		
		try {
			person = personService.save(person);
			
			System.out.println("Osoba je sacuvana");
			
			System.out.println(person);
			
		} catch (Exception e) {
			System.out.println("Main: greska -> " + e.getMessage());
		}
	}
	
	private void findAllPersons() {
		personService.findAll();
	}
	
	private void findPersonByCity(long cityId) {
		personService.findPersonByCity(cityId);
	}
	
	//save or update - sa predavanja:
	
	private void personSaveOrUpdate() {
		City city = new City();
		city.setId(2L);
		
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Marko");
		person.setLastName("Markovic");
		person.setPid("1212323232321");
		
		person.setCity(city);
				
		try {
			person = personService.saveOrUpdate(person);
			System.out.println(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//find by city - sa predavanja:
	
	private void personFindByCity() {
		City city = new City();
		city.setId(2L);
		List<Person> persons = personService.findByCity(city);
		for (Person person : persons) {
			System.out.println(person);
		}
	}

}
