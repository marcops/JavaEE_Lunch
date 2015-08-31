package org.marco.almoco.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.marco.almoco.facade.LoginFacade;
import org.marco.almoco.facade.ResultFacade;
import org.marco.almoco.model.RestaurantVote;
import org.marco.almoco.model.User;
import org.marco.almoco.model.UserVote;

@Named("resultMB")
@SessionScoped
public class ResultMB implements Serializable {

	private static final long serialVersionUID = -2281799246957671616L;
	//AQUI E DISCUTIVEL SE temos uma facade OU duas.
	@Inject
	private ResultFacade resultFacade;
	@Inject
	private LoginFacade loginFacade;

	public String getMyVote() {
		User user = loginFacade.getLogedUser();
		if (user != null) {
			UserVote userVote = resultFacade.getVoteByUser(user.getName());
			if (userVote != null) {
				return "Eu votei no: " + userVote.getRestaurant().getName();
			} else {
				return "Eu não votei =(";
			}
		} else {
			return "Você não esta logado!";
		}
	}

	public String getNumberVotes() {
		List<RestaurantVote> restaurantVotes = resultFacade.getAllVote();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Restaurantes Votados Hoje: ");
		for (RestaurantVote restaurantVote : restaurantVotes) {
			stringBuilder.append(restaurantVote.getRestaurant().getName());
			stringBuilder.append("(");
			stringBuilder.append(restaurantVote.getCount());
			stringBuilder.append("), ");

		}
		return stringBuilder.toString();
	}

	public String getRestaurantsResult() {
		RestaurantVote restaurantVote = resultFacade.getResult();
		if (restaurantVote != null) {
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 12) {
				return "Restaurante escolhido: "
						+ restaurantVote.getRestaurant().getName() + " com "
						+ restaurantVote.getCount() + " votos";
			} else {
				return "Restaurante escolhido Temporáriamente: "
						+ restaurantVote.getRestaurant().getName() + " com "
						+ restaurantVote.getCount() + " votos";
			}
		} else {
			return "Nao teve restaurante escolhido =( ";
		}

	}

}
