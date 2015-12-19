package com.bikestore.business;

import java.util.List;

import com.bikestore.domain.Menu;

public interface MenuService {

	List<Menu> getMenus(Long restaurantId);

	Menu save(Menu r);

	/**
	 * Cascade delete is configured for dishes on foreign key 
	 * @param id
	 */
	void delete(Long id);

}
