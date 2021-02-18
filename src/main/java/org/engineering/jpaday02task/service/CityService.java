package org.engineering.jpaday02task.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.engineering.jpaday02task.entity.City;

public class CityService implements Serializable{
	
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
	
	//save or update - sa predavanja:
	
	public City saveOrUpdate(City city) throws Exception{
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			if(city.getId()==null) {
				//sacuvaj samo pod uslovom da grad sa tim brojem ne postoji 
				List<City> cities = em.createQuery("SELECT c FROM City c WHERE c.number = :number") //:number
									.setParameter("number", city.getPib_number()).getResultList();
				if (cities.size()==0) em.persist(city);
				else throw new Exception("Grad sa tim postanskim brojem vec postoji");
			}else {
				City existingCity = em.find(City.class, city.getId());
				if (existingCity==null) throw new Exception("Grad sa ovim ID-jem ne postoji...");
				city = em.merge(city);
			}
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw e;
		}finally {
			em.close();
		}
		return city;
		
	}
}
