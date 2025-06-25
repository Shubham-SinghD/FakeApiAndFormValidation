package com.example.demo.entity;


import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
//@Data
@Entity
@Table(name = "form_submissions1")
public class FormSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
	private String name;
    private String email;
    private String password;
    private String phone;
    private String age; 
    private String gender;
    private String dob;
    private String time;
    private String state;
    private String message;
    private String java;
    private String sql;
    private String html;
    private String css;
    private String js;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="form_resume" ,
    joinColumns = @JoinColumn(name="form_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="resume_id",referencedColumnName = "id")
    		)
    
    private Set<PdfDocument>pdfDocument;

	public FormSubmission(String name, String email, String password, String phone, String age, String gender,
			String dob, String time, String state, String message, String java, String sql, String html, String css,
			String js, Set<PdfDocument> pdfDocument) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.time = time;
		this.state = state;
		this.message = message;
		this.java = java;
		this.sql = sql;
		this.html = html;
		this.css = css;
		this.js = js;
		this.pdfDocument = pdfDocument;
	}

	public FormSubmission() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getJs() {
		return js;
	}

	public void setJs(String js) {
		this.js = js;
	}

	public Set<PdfDocument> getPdfDocument() {
		return pdfDocument;
	}

	public void setPdfDocument(Set<PdfDocument> pdfDocument) {
		this.pdfDocument = pdfDocument;
	}
    
    
	
   


   
    

}

