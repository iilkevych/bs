package com.bikestore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikestore.business.RestaurantService;
import com.bikestore.domain.Restaurant;
import com.bikestore.web.core.Status;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@RequestMapping("/restaurants")
	public List<Restaurant> restaurants() {
		return restaurantService.getRestaurants();
	}

	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public Status add(Restaurant r) {
		Status s = new Status();
		s.setId(restaurantService.save(r).getId());
		return s;
	}

	@RequestMapping(value = "/restaurant", method = RequestMethod.DELETE)
	public Status delete(@RequestParam("id") Long id) {
		restaurantService.delete(id);
		return new Status();
	}
}
