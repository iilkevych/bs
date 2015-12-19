package com.bikestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikestore.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	public List<Menu> findByRestaurantName(String name);

	public List<Menu> findByRestaurantId(Long restaurantId);
}