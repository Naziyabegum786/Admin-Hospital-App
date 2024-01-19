package org.jsp.AdminHospitalDemo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false, unique=true)
	private long phone;
	
	@Column(nullable=false)
	private String Email;

	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy="admin")

	private List<Hospital> Hospitals;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Hospital> getHospitals() {
		return Hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		Hospitals = hospitals;
	}


}
