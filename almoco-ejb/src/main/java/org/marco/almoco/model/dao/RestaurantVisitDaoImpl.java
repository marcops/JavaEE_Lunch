package org.marco.almoco.model.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.enterprise.context.ApplicationScoped;

import org.marco.almoco.model.RestaurantVisit;
import org.marco.almoco.model.RestaurantVote;

@LocalBean
@ApplicationScoped
public class RestaurantVisitDaoImpl implements RestaurantVisitDao {

	private List<RestaurantVisit> list;

	@PostConstruct
	public void init() {
		list = new ArrayList<RestaurantVisit>();

	}

	public boolean containVisit() {
		if (list.size() > 0)
			return true;
		return false;
	}

	public void deleteAll() {
		list.clear();

	}

	public RestaurantVisit findRestaurantByVisit(int day) {
		for (RestaurantVisit restaurantVisit : list) {
			if( restaurantVisit.getCalendar().get(Calendar.DAY_OF_MONTH) == day )
				return restaurantVisit;
		}
		return null;
	}
	public List<RestaurantVisit> getAll(){
		return list;
	}
	public void add(RestaurantVote restaurant) {
		list.add(new RestaurantVisit(restaurant));
		
	}

}