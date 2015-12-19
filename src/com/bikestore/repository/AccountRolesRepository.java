package com.bikestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikestore.domain.AccountRole;

public interface AccountRolesRepository extends JpaRepository<AccountRole, Long> {
	
	public List<AccountRole> findByAccountId(Long accountId); 
}