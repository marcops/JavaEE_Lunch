package org.marco.almoco.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.enterprise.context.ApplicationScoped;

import org.marco.almoco.model.Restaurant;

@LocalBean
@ApplicationScoped
public class RestaurantDaoImpl implements RestaurantDao {
	private List<Restaurant> list;

	@PostConstruct
	public void init() {
		list = new ArrayList<Restaurant>();
		list.add(new Restaurant("Bom Sabor", 0)); // label, value
		list.add(new Restaurant("Boi Mugindo", 1));
		list.add(new Restaurant("Sabor latrino", 2));
		list.add(new Restaurant("Caseirinho", 3));
		list.add(new Restaurant("Tasty Mofadinho", 4));
		list.add(new Restaurant("Bife Vegano", 5));
		list.add(new Restaurant("MeK Donatelo", 6));
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return list;
	}
	@Override
	public Restaurant findById(int id){
		for (Restaurant restaurant : list) {
			if( restaurant.getValue() == id ) {
				return restaurant;
			}
		}
		return null;
	}
	

}