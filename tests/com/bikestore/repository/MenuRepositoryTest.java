package com.bikestore.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bikestore.domain.Dish;
import com.bikestore.domain.Menu;
import com.bikestore.domain.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-context.xml" })
public class MenuRepositoryTest {

	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(MenuRepository.class);;

	@Test
	public void testCreateMenu() {
		Restaurant r = new Restaurant();
		r.setName("MacD");
		r = restaurantRepository.save(r);

		Menu menu = new Menu();
		Set<Dish> dishes = new HashSet<Dish>();
		Dish main = new Dish("BigMac", 10L);
		main.setMenu(menu);
		dishes.add(main);
		Dish drink = new Dish("Cola", 10L);
		drink.setMenu(menu);
		dishes.add(drink);
		Dish sauce = new Dish("Ketchup", 10L);
		sauce.setMenu(menu);
		dishes.add(sauce);
		menu.setDishes(dishes);
		menu.setRestaurant(r);
		menuRepository.save(menu);

	}
}
