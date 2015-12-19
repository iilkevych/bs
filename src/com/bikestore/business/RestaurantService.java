package com.bikestore.business;

import java.util.List;

import com.bikestore.domain.Restaurant;

public interface RestaurantService {

	/**
	 * Fetch all restaurants with their menus. 
	 */
	public List<Restaurant> getRestaurants();

	public Restaurant save(Restaurant r);

	public Restaurant getRestaurant(Long id);

	public void delete(Long id);

}
