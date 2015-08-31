package org.marco.almoco.service;


import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.marco.almoco.model.User;
import org.marco.almoco.model.UserVote;
import org.marco.almoco.model.dao.RestaurantVisitDaoImpl;
import org.marco.almoco.model.dao.UserVoteDaoImpl;
import org.mockito.Mockito;

public class ManagerVoteServiceBeanTest {

	private ManagerVoteServiceBean service;
	private RestaurantVisitDaoImpl restaurantsVisit;
	private VoteRestaurantServiceBean voteRestaurantServiceBeanLocal;
	private UserVoteDaoImpl userVoteDao;
	private Calendar calMorning;
	private Calendar calAfternoon;
	
	@Before
	public void init() {
		service = new ManagerVoteServiceBean();
		
		restaurantsVisit = Mockito.mock(RestaurantVisitDaoImpl.class);
		service.setRestaurantsVisit(restaurantsVisit);
		voteRestaurantServiceBeanLocal = Mockito.mock(VoteRestaurantServiceBean.class);
		service.setVoteRestaurantServiceBeanLocal(voteRestaurantServiceBeanLocal);
		
		userVoteDao = Mockito.mock(UserVoteDaoImpl.class);
		service.setUserVote(userVoteDao);
		
		calMorning = Calendar.getInstance();
		calMorning.set(Calendar.HOUR_OF_DAY, 10);
		
		calAfternoon = Calendar.getInstance();
		calAfternoon.set(Calendar.HOUR_OF_DAY, 15);
	}
	
	@Test
	public void shouldReturnFalseWhenUserNotVoted() {
		Mockito.when(userVoteDao.getVoteByUser(Mockito.anyString())).thenReturn(null);
		//se e demanha e usuario nao votou ainda...
		Assert.assertFalse("Erro de retorno caso usuario nao tenha votado",service.userVoted("marco",calMorning));
	}
	@Test
	public void shouldReturnTrueWhenUserVoted() {
		Mockito.when(userVoteDao.getVoteByUser(Mockito.anyString())).thenReturn(new UserVote(new User("ROGER", "THAT"), null));
		//se e demanha e usuario votou...
		Assert.assertTrue("Erro de retorno caso usuario tenha votado",service.userVoted("ROGER",calMorning));
	}
	@Test
	public void shouldReturnTrueForShowResultAtAfternoon() {
		Mockito.when(userVoteDao.getVoteByUser(Mockito.anyString())).thenReturn(null);
		//se e detarde nao pode votar
		Assert.assertTrue("Erro de retorno caso usuario possa votar",service.userVoted("marco",calAfternoon));
	}
	//FEITO testes minimo do minimo...

}
