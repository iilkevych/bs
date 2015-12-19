package com.bikestore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikestore.business.MenuService;
import com.bikestore.domain.Menu;
import com.bikestore.web.core.Status;

@RestController
public class MenuController {

	@Autowired
	MenuService menusService;

	@RequestMapping("/menus")
	public List<Menu> restaurants(@RequestParam("restaurantId") Long restaurantId) {
		return menusService.getMenus(restaurantId);
	}

	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public Status add(@RequestBody Menu r) {
		Status s = new Status();
		s.setId(menusService.save(r).getId());
		return s;
	}

	@RequestMapping(value = "/menu", method = RequestMethod.DELETE)
	public Status delete(@RequestParam("id") Long id) {
		menusService.delete(id);
		return new Status();
	}
}
