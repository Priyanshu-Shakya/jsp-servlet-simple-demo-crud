package com.infosys.servlet_simple_demo_crud.entity;

import java.time.LocalDate;

public class Student {
	
	private int id;
	private String name;
	private String password;
	private String email;
	private Long phone;
	private LocalDate dob;
	private String gender;
	
	public Student(){
		
	}

	public Student(int id, String name, String password, String email, Long phone, LocalDate dob, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", dob=" + dob + ", gender=" + gender + "]";
	}
	
	
	
}
