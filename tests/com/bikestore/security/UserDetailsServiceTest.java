package com.bikestore.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/data-context.xml", "classpath:/security-context.xml" })
public class UserDetailsServiceTest {

	@Autowired
	private UserDetailsService userDetailsService;

	private final Logger logger = LoggerFactory.getLogger(UserDetailsServiceTest.class);;

	@Test
	public void test() {
		
		logger.info("hi " + userDetailsService.loadUserByUsername("john"));
	}

}
