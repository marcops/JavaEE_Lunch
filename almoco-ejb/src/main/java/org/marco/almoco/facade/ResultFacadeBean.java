package org.marco.almoco.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.marco.almoco.model.RestaurantVote;
import org.marco.almoco.model.UserVote;
import org.marco.almoco.model.dao.UserVoteDao;
import org.marco.almoco.service.VoteRestaurantServiceBeanLocal;

@Stateless
public class ResultFacadeBean implements ResultFacade {

	@Inject
	private UserVoteDao userVoteDao;
	
	@Inject
	private VoteRestaurantServiceBeanLocal voteRestaurantServiceBeanLocal;

	public RestaurantVote getResult() {
		return voteRestaurantServiceBeanLocal.getResult();
	}
	public List<RestaurantVote> getAllVote() {
		return voteRestaurantServiceBeanLocal.getAllVote();
	}
	public UserVote getVoteByUser(String name) {
		return userVoteDao.getVoteByUser(name);
	}
	
}
