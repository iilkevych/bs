package com.bikestore.business;

import java.util.List;

import com.bikestore.domain.aggregation.MenuRating;
import com.bikestore.web.core.Status;

public interface VotesService {

	public List<MenuRating> top();

	public Status vote(String menuId, String username);
}
