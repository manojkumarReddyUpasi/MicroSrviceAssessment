package com.service2.microservice.dto;

import java.util.ArrayList;
import java.util.List;

public class MegaMenuDTO {
	int id;
	Integer parentId; 
	String Name;
	String color;
	List<MegaMenuDTO> childrenItems =new ArrayList<MegaMenuDTO>();
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<MegaMenuDTO> getChildrenItems() {
		return childrenItems;
	}
	public void setChildrenItems(List<MegaMenuDTO> childrenItems) {
		this.childrenItems = childrenItems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	 public void addChildrenItem(MegaMenuDTO childrenItem){
	        if(!this.childrenItems.contains(childrenItem))
	            this.childrenItems.add(childrenItem);
	    }
	@Override
	public String toString() {
		return "MegaMenuDTO [id=" + id + ", parentId=" + parentId + ", Name=" + Name + ", childrenItems="
				+ childrenItems + "]";
	}
	

}
