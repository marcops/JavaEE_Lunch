package org.marco.almoco.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;

import org.marco.almoco.model.RestaurantVisit;
import org.marco.almoco.model.Restaurant;
import org.marco.almoco.model.dao.RestaurantDao;
import org.marco.almoco.model.dao.RestaurantVisitDao;


/**
 * Session Bean implementation class LanchServiceBean
 */
@Stateful
@LocalBean
public class RestaurantServiceBean implements RestaurantServiceBeanLocal {

	@Inject
	private RestaurantDao restaurantDao;
	@Inject
	private RestaurantVisitDao restaurantsVisitDao;

	
	@Override
	public List<Restaurant> getListRestaurant() {
		return restaurantDao.getAllRestaurant();
	}

	@Override
	public List<Restaurant> getAllRestaurantNotVoted() {
		List<Restaurant> newlist = new ArrayList<Restaurant>();
		List<RestaurantVisit> restaurantsVisit= restaurantsVisitDao.getAll();

		for (Restaurant rest : restaurantDao.getAllRestaurant()) {
			boolean found = false;
			for (RestaurantVisit restaurantVisit : restaurantsVisit) {
				if (rest.getName()
						.compareTo(restaurantVisit.getRestaurantVote().getRestaurant().getName()) == 0) {
					found = true;
				}
			}
			if (!found)
				newlist.add(rest);
		}

		return newlist;
	}

}
