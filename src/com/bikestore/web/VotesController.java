package com.bikestore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikestore.business.VotesService;
import com.bikestore.domain.aggregation.MenuRating;
import com.bikestore.web.core.Status;

@RestController
public class VotesController {

	@Autowired
	VotesService votesService;
	
	@RequestMapping("/top")
	public List<MenuRating> top(ModelMap model) {
		return votesService.top();
	}

	@RequestMapping("/vote")
	public Status vote(@RequestParam("menu") String menuId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return votesService.vote(menuId, authentication.getName());
	}
}
