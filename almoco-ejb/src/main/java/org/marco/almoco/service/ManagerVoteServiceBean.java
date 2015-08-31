package org.marco.almoco.service;

import java.util.Calendar;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;

import org.marco.almoco.model.UserVote;
import org.marco.almoco.model.dao.RestaurantVisitDao;

import org.marco.almoco.model.dao.UserVoteDao;

@Stateful
@LocalBean
public class ManagerVoteServiceBean implements ManagerVoteServiceBeanLocal {

	@Inject
	private UserVoteDao userVoteDao;
	@Inject
	private RestaurantVisitDao restaurantsVisitDao;
	@Inject
	private VoteRestaurantServiceBeanLocal voteRestaurantServiceBeanLocal;

	@Override
	public boolean computeUserVote(UserVote user) {
		userVoteDao.add(user);
		return true;
	}

	@Override
	public boolean userVoted(String name) {
		// para facilitar os testes no UNITTEST e poder simular a troca de
		// horario
		return userVoted(name, Calendar.getInstance());
	}

	private boolean restauranteAreVisitedToday(Calendar actualDate) {
		if (restaurantsVisitDao.findRestaurantByVisit(actualDate
				.get(Calendar.DAY_OF_MONTH)) == null) {
			return false;
		}
		return true;
	}

	private boolean hadVoteToday() {
		if (voteRestaurantServiceBeanLocal.getResult() == null) {
			return false;
		}
		return true;
	}

	private void processAllVote() {
		// computa todos os votos
		restaurantsVisitDao.add(voteRestaurantServiceBeanLocal.getResult());
		// reseta os votos diarias
		voteRestaurantServiceBeanLocal.reset();
		// reseta votos dos usuarios no dia
		userVoteDao.deleteAll();
	}

	private void processVoteOfDay(Calendar actualDate) {
		// verifica se visitaram algum restaurante hoje
		if (!restauranteAreVisitedToday(actualDate)) {
			// verifica se votaram....
			// pode acontecer de visitar e nao ter tido votacao?????? eu
			// acho que nao.. mas neh...
			if (hadVoteToday()) {
				processAllVote();
			}
		}
	}

	private boolean isMiddayPassed(Calendar actualDate) {
		if (actualDate.get(Calendar.HOUR_OF_DAY) >= 12) {
			// nao pode mais votar... ja passou da hora do almoço
			return true;
		}
		return false;
	}

	private void processSunday(Calendar actualDate) {
		if (actualDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				&& restaurantsVisitDao.containVisit()) {
			// reseta restaurantes visitados! afinal e segunda demanha!
			restaurantsVisitDao.deleteAll();
		}
	}

	public boolean userVoted(String name, Calendar actualDate) {
		if (name == null) {
			return false;
		}
		if (isMiddayPassed(actualDate)) {
			processVoteOfDay(actualDate);
			// se passou do meio dia nao pode mais votar.. so ver o resultado!
			return true;
		}
		processSunday(actualDate);

		return userHasVotedToday(name, actualDate);

	}

	private boolean userHasVotedToday(String name, Calendar actualDate) {
		UserVote user = userVoteDao.getVoteByUser(name);
		if (user == null) {
			return false;
		}
		// verifica se o usuario ja votou hoje...
		if (user.getDateVoted().get(Calendar.DAY_OF_MONTH) == actualDate
				.get(Calendar.DAY_OF_MONTH)
				&& user.getDateVoted().get(Calendar.MONTH) == actualDate
						.get(Calendar.MONTH)
				&& user.getDateVoted().get(Calendar.YEAR) == actualDate
						.get(Calendar.YEAR)) {
			return true;

		}
		return false;
	}

	public void setRestaurantsVisit(RestaurantVisitDao restaurantsVisit) {
		this.restaurantsVisitDao = restaurantsVisit;
	}

	public void setUserVote(UserVoteDao userVoteArg) {
		this.userVoteDao = userVoteArg;
	}

	public void setVoteRestaurantServiceBeanLocal(
			VoteRestaurantServiceBeanLocal voteRestaurantServiceBeanLocal) {
		this.voteRestaurantServiceBeanLocal = voteRestaurantServiceBeanLocal;
	}

}
