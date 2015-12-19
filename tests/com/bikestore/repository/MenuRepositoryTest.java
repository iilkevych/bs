package com.bikestore.repository;

import java.util.HashSet;
import java.util.List;
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
	private DishRepository dishRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(MenuRepository.class);;
	
	//@Test
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

	@Test
	public void testUpdateMenu() {
		List<Menu> menus = menuRepository.findAll();
		Menu menu = menus.get(0);
		Menu input = new Menu();
		input.setId(menu.getId());
		Restaurant restaurant = menu.getRestaurant();
		Restaurant inputR = new Restaurant();
		inputR.setId(restaurant.getId());
		inputR.setName(restaurant.getName());
		input.setRestaurant(inputR);
		Set<Dish> dishes = menu.getDishes();
		Set<Dish> deleted = new HashSet<Dish>();
		input.setDishes(new HashSet<Dish>());
		for(Dish d : dishes) {
			if(!"Cola".equals(d.getName()) && !"BigMac".equals(d.getName()) ){
				Dish ind = new Dish();
				ind.setId(d.getId());
				ind.setName(d.getName());
				ind.setPrice(d.getPrice() + 1);
				ind.setMenu(input);
				input.getDishes().add(ind);
			} else {
				deleted.add(d);
			}
		}
		dishRepository.deleteInBatch(deleted);
		Dish pepsi = new Dish("Pepsi", 10L);
		pepsi.setMenu(input);
		input.getDishes().add(pepsi);
		menuRepository.save(input);
	}

	//@Test
	public void testCleanDB() {
		restaurantRepository.deleteAll();
	}
	
}
