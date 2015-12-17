package com.bikestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikestore.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	Menu findByRestaurantName(String name);
}