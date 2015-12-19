package com.bikestore.business;

import com.bikestore.domain.Account;

public interface AccountService {

	public Account getByUsername(String username);

	public Account save(Account account);

}
