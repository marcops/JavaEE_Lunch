package org.marco.almoco.service;

import java.util.List;

import javax.ejb.Local;

import org.marco.almoco.model.Restaurant;

@Local
public interface RestaurantServiceBeanLocal {

	List<Restaurant> getListRestaurant();
	
	List<Restaurant> getAllRestaurantNotVoted();

}
