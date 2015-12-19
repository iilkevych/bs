package com.bikestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikestore.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByUsername(String username);
}