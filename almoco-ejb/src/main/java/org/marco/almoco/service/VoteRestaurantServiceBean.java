package org.marco.almoco.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;

import org.marco.almoco.model.RestaurantVote;
import org.marco.almoco.model.UserVote;
import org.marco.almoco.model.dao.RestaurantDao;
import org.marco.almoco.model.dao.RestaurantVoteDao;
import org.marco.almoco.model.dao.UserDao;
import org.marco.almoco.model.dao.UserVoteDao;


/**
 * Session Bean implementation class LanchServiceBean
 */
@Stateful
@LocalBean
public class VoteRestaurantServiceBean implements
		VoteRestaurantServiceBeanLocal {

	@Inject
	private UserVoteDao userVoteDao;
	@Inject
	private UserDao userDao;
	@Inject
	private RestaurantVoteDao restaurantVoteDao;
	@Inject
	private RestaurantDao restauranteDao;
	

	@Override
	public List<RestaurantVote> getAllVote() {
		return restaurantVoteDao.getAllVote();
	}

	@Override
	public void voteOnRestaurant(String index) {
		Integer id = new Integer(index);
	
		RestaurantVote restaurantVote = restaurantVoteDao.findByRestaurantId(id);
		if( restaurantVote == null ) {
			restaurantVote = new RestaurantVote(restauranteDao.findById(id));
			restaurantVoteDao.add(restaurantVote);
		}
		restaurantVote.addVote();
		
		UserVote userVote = new UserVote(userDao.getUserLogged(),restaurantVote.getRestaurant());
		userVoteDao.add(userVote);
	}

	@Override
	public RestaurantVote getResult() {
		RestaurantVote found = null;
		for (RestaurantVote vote : restaurantVoteDao.getAllVote()) {
			if (found == null || vote.getCount() > found.getCount()) {
				found = vote;
			}
		}
		return found;
	}

	@Override
	public void reset() {
		restaurantVoteDao.deleteAll();
	}

}
