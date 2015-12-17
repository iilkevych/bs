package com.bikestore.domain.aggregation;

import com.bikestore.domain.Menu;

public class MenuRating {
	private final Menu menu;
	private final long rating;

	public MenuRating(Menu menu, long rating) {
		this.menu = menu;
		this.rating = rating;
	}

	public Menu getMenu() {
		return menu;
	}

	public long getRating() {
		return rating;
	}
}
