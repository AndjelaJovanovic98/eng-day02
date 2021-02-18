package org.engineering.jpaday02;

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
		
		startPerson.findPersonByCity(1);

	}
	
	private void save(int pid, String firstName, String lastName, long cityNumber) {
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

}
