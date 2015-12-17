package com.bikestore.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bikestore.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-context.xml" })
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;

	private final Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);;

	@Test
	public void testCreateAccount() {
		Account a = new Account();
		a.setFirstName("Ihor");
		a.setLastName("Ilkevych");
		a.setPassword("p");
		a.setUsername("iilkev");
		a.setEnabled(true);
		accountRepository.save(a);
		logger.info(String.valueOf(a.getId()));
	}

}
