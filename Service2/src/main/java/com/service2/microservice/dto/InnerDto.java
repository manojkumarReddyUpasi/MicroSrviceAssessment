package com.service2.microservice.dto;

public class InnerDto {

	String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
public int hashCode(){
		
		int hashcode = 0;
		
		hashcode += Name.hashCode();
		return hashcode;
	}
	
	public boolean equals(Object obj){
		
		if (obj instanceof InnerDto) {
			InnerDto pp = (InnerDto) obj;
			return (pp.Name.equals(this.Name));
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "InnerDto [Name=" + Name + "]";
	}
	
	
}
