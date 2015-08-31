package org.marco.almoco.model.dao;

import java.util.List;

import org.marco.almoco.model.RestaurantVote;

public interface RestaurantVoteDao {
	
	List<RestaurantVote> getAllVote();
	
	void deleteAll();

	RestaurantVote findByRestaurantId(int id);

	void add(RestaurantVote restaurantVote);
	
}