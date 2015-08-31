package org.marco.almoco.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.marco.almoco.facade.VoteRestaurantFacade;

import org.marco.almoco.model.Restaurant;


@Named("voteRestaurantMB")
@SessionScoped
public class VoteRestaurantMB implements Serializable {

	private static final long serialVersionUID = 2139347399975906456L;
	@Inject
	private VoteRestaurantFacade voteRestaurantFacade;

	private Restaurant[] restaurants;

	

	public void setRestaurantsInString(String index) {
		voteRestaurantFacade.voteOnRestaurant(index);

	}

	public String getRestaurantsInString() {
		return Arrays.toString(restaurants);
	}

	public String vote() {
		return "success";
	}

	public List<Restaurant> getRestaurant() {
		// trazer restaurantes nao VOTADOS na semana
		return voteRestaurantFacade.getRestaurantNotVoted();

	}

}
