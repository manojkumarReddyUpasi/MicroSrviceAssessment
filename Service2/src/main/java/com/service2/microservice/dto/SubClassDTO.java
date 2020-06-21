package com.service2.microservice.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SubClassDTO {
	String Name;
	@JsonIgnore
	Set<InnerDto> SubClass=new HashSet<InnerDto>();
	public String getName() {
		return Name;
	}
	public Set<InnerDto> getSubClass() {
		return SubClass;
	}

	public void setSubClass(Set<InnerDto> subClass) {
		SubClass = subClass;
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
		
		if (obj instanceof SubClassDTO) {
			SubClassDTO pp = (SubClassDTO) obj;
			return (pp.Name.equals(this.Name));
		} else {
			return false;
		}
	}
	

	@Override
	public String toString() {
		return "SubClassDTO [Name=" + Name + "]";
	}
	
	

}
