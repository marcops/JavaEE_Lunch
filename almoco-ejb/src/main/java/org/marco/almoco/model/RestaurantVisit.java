package org.marco.almoco.model;

import java.util.Calendar;

public class RestaurantVisit {
	private RestaurantVote restaurant;
	private Calendar calendar;
	public RestaurantVisit(RestaurantVote rest) {
		calendar = Calendar.getInstance();
		restaurant = rest;
	}
	public RestaurantVote getRestaurantVote() {
		return restaurant;
	}
	public void setRestaurantVote(RestaurantVote restaurant) {
		this.restaurant = restaurant;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	
}
