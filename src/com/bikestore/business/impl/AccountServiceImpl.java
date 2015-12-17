package com.bikestore.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikestore.business.AccountService;
import com.bikestore.domain.Account;
import com.bikestore.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account getByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

}
