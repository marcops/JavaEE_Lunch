package org.marco.almoco.model;

import java.util.Calendar;

public class UserVote {
	private User user;
	private Calendar calendar;
	private Restaurant restaurant;

	public UserVote(User user, Restaurant restaurant) {
		this.user=user;
		this.restaurant = restaurant;	
		this.calendar = Calendar.getInstance();
	}
	public Calendar getDateVoted() {
		return calendar;
	}

	public void setDate(Calendar cal) {
		this.calendar = cal;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
