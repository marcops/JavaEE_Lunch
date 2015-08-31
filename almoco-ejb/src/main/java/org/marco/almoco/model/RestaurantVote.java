package org.marco.almoco.model;


public class RestaurantVote {
	private Restaurant restaurant;
	private int count;
	
	public RestaurantVote(Restaurant restaurant) {
		this.restaurant = restaurant;
		count = 0;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public int getCount() {
		return count;
	}
	public void addVote() {
		this.count++;
	}
	
}
