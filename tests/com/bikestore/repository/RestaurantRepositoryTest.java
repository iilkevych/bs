package com.bikestore.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bikestore.domain.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-context.xml" })
public class RestaurantRepositoryTest {

	@Autowired
	private RestaurantRepository restaurantRepository;

	private final Logger logger = LoggerFactory.getLogger(RestaurantRepository.class);;

	@Test
	public void testCreateRestaurant() {
		Restaurant r = new Restaurant();
		r.setName("MacD");
		r = restaurantRepository.save(r);
		restaurantRepository.delete(r);
	}

	@Test
	public void testFindRestaurantByName() {
		Restaurant r = restaurantRepository.findByName("MacD");
		logger.info(r.getName());
	}

}
