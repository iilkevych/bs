package com.bikestore.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bikestore.domain.Vote;
import com.bikestore.domain.aggregation.MenuRating;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-context.xml" })
public class VotesRepositoryTest {

	@Autowired
	private VotesRepository votesRepository;
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private AccountRepository accountRepository;

	private final Logger logger = LoggerFactory.getLogger(VotesRepository.class);;

	@Test
	public void testVoteRestaurant() {
		Vote v = new Vote();
		v.setAccount(accountRepository.findByUsername("iilkev"));
		v.setMenu(menuRepository.findByRestaurantName("MacD").get(0));
		votesRepository.save(v);
	}
	@Test
	public void testCountVotesByRestaurant() {
		List<MenuRating> results = votesRepository.getVotes();
		for(MenuRating result: results){
			logger.info(result.getMenu().getRestaurant().getName());
			logger.info(String.valueOf(result.getMenu().getDishes().size()));
		}
	}
}
