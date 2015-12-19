package com.bikestore.business.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikestore.business.MenuService;
import com.bikestore.domain.Dish;
import com.bikestore.domain.Menu;
import com.bikestore.repository.DishRepository;
import com.bikestore.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	DishRepository dishRepository;

	@Override
	public List<Menu> getMenus(Long restaurantId) {
		return menuRepository.findByRestaurantId(restaurantId);
	}

	@Override
	public Menu save(Menu menu) {
		List<Dish> dishes= dishRepository.findByMenuId(menu.getId());
		Set<Dish> input = menu.getDishes();
		Set<Dish> deleted = new HashSet<Dish>();
		for(Dish d : dishes) {
			if(!input.contains(d)){
				deleted.add(d);
			}
		}

		dishRepository.deleteInBatch(deleted);
		return menuRepository.save(menu);
	}

	@Override
	public void delete(Long id) {
		menuRepository.delete(id);
	}
}
