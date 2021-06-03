package com.seid.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="users")
@XmlRootElement(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="country")
	private String country;
	
	// hibernate newInstance() metodu ile persistent class'indan bir obje olusturabilsin diye
	// bos bir constructor metod olusturmamiz oneriliyormus.
	public User() { }
	
	public User(String name, String email, String country) {
		setName(name);
		setEmail(email);
		setCountry(country);
	}
	
	public User(int id, String name, String email, String country) {
		this(name, email, country);
		setId(id);
	}

	// eclipse tarafindan olusturulan get-set metodlari (right click -> source -> generate getters and setters)
	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}
	
}
