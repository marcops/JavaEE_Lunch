package org.marco.almoco.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.marco.almoco.model.Restaurant;
import org.marco.almoco.service.RestaurantServiceBeanLocal;
import org.marco.almoco.service.VoteRestaurantServiceBeanLocal;

@Stateless
public class VoteRestaurantFacadeBean implements VoteRestaurantFacade {

	@Inject
	private VoteRestaurantServiceBeanLocal voteRestaurantServiceBeanLocal;

	@Inject
	private RestaurantServiceBeanLocal restaurantServiceBeanLocal;

	public List<Restaurant> getRestaurantNotVoted() {
		return restaurantServiceBeanLocal.getAllRestaurantNotVoted();

	}

	public void voteOnRestaurant(String index) {
		voteRestaurantServiceBeanLocal.voteOnRestaurant(index);
	}
}
