package org.engineering.jpaday02task.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.engineering.jpaday02task.entity.City;

public class CityService {
	
	private EntityManagerFactory emf;
	
	public CityService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public City save(City city) throws Exception{
		//TODO validation
		
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(city);
			em.getTransaction().commit();
			System.out.println("ID: " + city.getId());
			return city;
		} catch (Exception e ) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	
	}
}
