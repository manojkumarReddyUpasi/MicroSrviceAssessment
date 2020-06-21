package com.service2.microservice.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResponseDTO {
	String Name;
	Set<SubClassDTO> SubClasses=new HashSet<>();
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Set<SubClassDTO> getSubClasses() {
		return SubClasses;
	}
	public void setSubClasses(Set<SubClassDTO> subClasses) {
		SubClasses = subClasses;
	}
	
	public int hashCode(){
		
		int hashcode = 0;
		
		hashcode += Name.hashCode();
		return hashcode;
	}
	
	public boolean equals(Object obj){
		
		if (obj instanceof ResponseDTO) {
			ResponseDTO pp = (ResponseDTO) obj;
			return (pp.Name.equals(this.Name));
		} else {
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return "ResponseDTO [Name=" + Name + ", SubClasses=" + SubClasses + "]";
	}
	
	
	
}
