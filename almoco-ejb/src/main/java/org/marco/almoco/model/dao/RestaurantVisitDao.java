package org.marco.almoco.model.dao;

import java.util.List;

import org.marco.almoco.model.RestaurantVisit;
import org.marco.almoco.model.RestaurantVote;



public interface RestaurantVisitDao {
	
	public boolean containVisit();
	public void deleteAll() ;
	public void add(RestaurantVote restaurant);
	public RestaurantVisit findRestaurantByVisit(int day);
	public List<RestaurantVisit> getAll();
	
}