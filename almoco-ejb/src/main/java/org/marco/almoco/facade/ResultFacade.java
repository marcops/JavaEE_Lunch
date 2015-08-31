package org.marco.almoco.facade;

import java.util.List;

import org.marco.almoco.model.RestaurantVote;
import org.marco.almoco.model.UserVote;

public interface ResultFacade {
	public RestaurantVote getResult();

	public List<RestaurantVote> getAllVote();
	
	public UserVote getVoteByUser(String name);
}
