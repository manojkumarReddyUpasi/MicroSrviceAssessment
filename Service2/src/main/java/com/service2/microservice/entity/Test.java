package com.service2.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {
	@Id
	@Column(name = "id")
	int childId;
	
	@Column(name ="parentid")
	int parentId;
	
	@Column(name="name")
	String name;
	
	@Column(name="color")
	String color;

	public Test() {}
	

	
	public Test(int childId, int parentId, String name, String color) {
		super();
		this.childId = childId;
		this.parentId = parentId;
		this.name = name;
		this.color = color;
	}
	public int getChildId() {
		return childId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Test [childId=" + childId + ", parentId=" + parentId + ", name=" + name + ", color=" + color + "]";
	}
}
