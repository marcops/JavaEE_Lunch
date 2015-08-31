package org.marco.almoco.model.dao;

import java.util.List;

import org.marco.almoco.model.Restaurant;

public interface RestaurantDao {
	
	public List<Restaurant> getAllRestaurant();

	public Restaurant findById(int id);
}