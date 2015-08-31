package org.marco.almoco.model;



public class Restaurant {
	private String name;
	private int value;

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String restaurant) {
		this.name = restaurant;
	}
	

	public Restaurant(String name,int value) {
		this.value = value;
		this.name = name;
	
	}
	
}