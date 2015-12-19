package com.bikestore.business;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bikestore.domain.Account;
import com.bikestore.domain.AccountRole;
import com.bikestore.security.RoleType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-context.xml", "classpath:/business-context.xml" })
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	private final Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);;

	@Test
	public void testCreateAccount() {
		Account a = new Account();
		a.setFirstName("Ihor");
		a.setLastName("Ilkevych");
		a.setPassword("5f4dcc3b5aa765d61d8327deb882cf99"); //password
		a.setUsername("iilkev");
		a.setEnabled(true);
		
		a = accountService.save(a);
		logger.info(String.valueOf(a.getId()));
		
		Set<AccountRole> accountRoles = new HashSet<AccountRole>();
		AccountRole admin  = new AccountRole();
		admin.setAccount(a);
		admin.setRole(RoleType.ROLE_ADMIN);
		accountRoles.add(admin);
		a.setAccountRoles(accountRoles);
		a = accountService.save(a);
		logger.info(String.valueOf(a.getId()));
	}

}
