package com.bikestore.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bikestore.domain.Account;
import com.bikestore.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-context.xml" })
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;

	private final Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);;

	@Test
	public void test() {

		List<Account> accounts = accountRepository.findAll();
		for(Account account: accounts){
			logger.info(account.getUsername() + " has " + account.getAccountRoles().size() + " roles");
		}
	}

}
