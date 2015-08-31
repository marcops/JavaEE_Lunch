package org.marco.almoco.service;

import java.util.List;

import javax.ejb.Local;

import org.marco.almoco.model.RestaurantVote;

@Local
public interface VoteRestaurantServiceBeanLocal {

	void voteOnRestaurant(String index);

	RestaurantVote getResult();
	
	void reset();

	List<RestaurantVote> getAllVote();

}
