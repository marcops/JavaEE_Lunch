package org.marco.almoco.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.enterprise.context.ApplicationScoped;

import org.marco.almoco.model.RestaurantVote;


@LocalBean
@ApplicationScoped
public class RestaurantVoteDaoImpl implements RestaurantVoteDao {
	private List<RestaurantVote> list;

	@PostConstruct
	public void init() {
		list = new ArrayList<RestaurantVote>();		
	}

	@Override
	public List<RestaurantVote> getAllVote() {
		return list;
	}

	@Override
	public void deleteAll() {
		list.clear();
	}
	@Override
	public void add(RestaurantVote restaurantVote) {
		list.add(restaurantVote);
	}

	@Override
	public RestaurantVote findByRestaurantId(int id) {
		for (RestaurantVote vote : list) {
			if (vote.getRestaurant().getValue() == id) {
				return vote;
			}
		}
		return null;
	}

	public boolean containVote() {
		if (list.size() > 0)
			return true;
		return false;
	}

}