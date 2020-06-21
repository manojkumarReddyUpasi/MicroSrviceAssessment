package com.service1.microservice.dto;

public class ConcatenatedDTO {
	private String Name;
	private String Surname;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	@Override
	public String toString() {
		return "{ Name=" + Name + ", Surname=" + Surname + "}";
	}
	
	

}
