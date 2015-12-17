package com.bikestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikestore.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	Restaurant findByName(String string);
}