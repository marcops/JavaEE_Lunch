package org.marco.almoco.facade;

import java.util.List;

import org.marco.almoco.model.Restaurant;

public interface VoteRestaurantFacade {
	List<Restaurant> getRestaurantNotVoted();
	void voteOnRestaurant(String index);
}
