package com.bikestore.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.bikestore.business.VotesService;
import com.bikestore.domain.Account;
import com.bikestore.domain.Menu;
import com.bikestore.domain.Vote;
import com.bikestore.domain.aggregation.MenuRating;
import com.bikestore.repository.AccountRepository;
import com.bikestore.repository.MenuRepository;
import com.bikestore.repository.VotesRepository;
import com.bikestore.web.core.Status;

@Service
public class VotesServiceImpl implements VotesService {

	@Autowired
	VotesRepository votesRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	MenuRepository menuRepository;

	@Override
	public List<MenuRating> top() {
		return votesRepository.getVotes();
	}

	@Override
	public Status vote(String menuId, String username) {
		Status s = new Status();
		Menu m = menuRepository.getOne(Long.valueOf(menuId));
		Account a = accountRepository.findByUsername(username);
		try {
			votesRepository.save(new Vote(a, m));
		} catch (JpaSystemException e) {
			s.setCode(-1);
			s.setErrormessage(e.getRootCause().getMessage());
		}
		return s;
	}

}
