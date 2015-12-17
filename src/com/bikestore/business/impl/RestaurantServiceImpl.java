package com.bikestore.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikestore.business.RestaurantService;
import com.bikestore.domain.Restaurant;
import com.bikestore.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant save(Restaurant r) {
		return restaurantRepository.save(r);
	}

	@Override
	public void delete(Long id) {
		restaurantRepository.delete(id);
	}

}
