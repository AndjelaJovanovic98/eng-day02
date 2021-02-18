package org.engineering.jpaday02task.entity;

import javax.persistence.*;

@Entity
public class Person {
	private static final long serialVersionUID = 1802021120500L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int pid;
	private String firstName;
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name="bornCity")
	private City city;

	public Person(Long id, int pid, String firstName, String lastName, City city) {
		super();
		this.id = id;
		this.pid = pid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	public Person() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + "]";
	}
	
	
}
