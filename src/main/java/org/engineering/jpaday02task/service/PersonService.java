package org.engineering.jpaday02task.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.engineering.jpaday02task.entity.City;
import org.engineering.jpaday02task.entity.Person;

public class PersonService {

	private EntityManagerFactory emf;

	public PersonService(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public Person save(Person person) throws Exception {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			City city = em.find(City.class, person.getCity().getId());
			if (city == null) {
				em.persist(person.getCity());
			}
			person = em.merge(person);
			em.getTransaction().commit();
			System.out.println("ID: " + person.getId());
			return person;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	
	public void findAll() {
		EntityManager em = emf.createEntityManager();
		
		List<Person> persons = em.createQuery("SELECT person FROM Person person").getResultList();
		for (Person person : persons) {
			System.out.println(person);
			
		}
		em.close();
	}
	
	public void findPersonByCity(long cityId) {
		EntityManager em = emf.createEntityManager();
		
		List<Person> persons = em.createNativeQuery( "SELECT * FROM PERSON  WHERE PERSON.bornCity = '" + cityId + "'", Person.class).getResultList();
		
		for(Person person : persons) {
			System.out.println(person);
		}
		
		em.close();
	}
}
