package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Shubham_contact_form")
public class ContactForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true,nullable=true)
	private String email;
	private String phone1;
	private String phone2;
	private String phone3;
	private String firstname;
	private String lastname;
	private String massagesubject;
	private String massage;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMassagesubject() {
		return massagesubject;
	}
	public void setMassagesubject(String massagesubject) {
		this.massagesubject = massagesubject;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public ContactForm(String email, String phone1, String phone2, String phone3, String firstname, String lastname,
			String massagesubject, String massage) {
		super();
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.firstname = firstname;
		this.lastname = lastname;
		this.massagesubject = massagesubject;
		this.massage = massage;
	}
	public ContactForm() {
		super();
	}
	
	

}
