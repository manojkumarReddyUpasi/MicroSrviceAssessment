package com.service2.microservice.dto;

public class Pair {
	private int childId;
	private int parentId;
	private String name;
	
	public Pair(){}
	public Pair(int childId, int parentId,String name) {
		super();
		this.name=name;
		this.childId = childId;
		this.parentId = parentId;
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
	@Override
	public String toString() {
		return "Pair -> {childId=" + childId + ", parentId=" + parentId + ", name=" + name + "}";
	}
	
	
	
}
