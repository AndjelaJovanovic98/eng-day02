package org.engineering.jpaday02task.entity;

import javax.persistence.*;

@Entity
public class City {
	
	private static final long serialVersionUID = 1802021122900L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int pib_number;
	private String name;
	public City(Long id, int pib_number, String name) {
		super();
		this.id = id;
		this.pib_number = pib_number;
		this.name = name;
	}
	
	public City(Long id) {
		super();
		this.id = id;
		
	}
	
	public City() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPib_number() {
		return pib_number;
	}
	public void setPib_number(int pib_number) {
		this.pib_number = pib_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
