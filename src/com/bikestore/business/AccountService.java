package com.bikestore.business;

import com.bikestore.domain.Account;

public interface AccountService {

	Account getByUsername(String username);

}
