package com.catalyst.devworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.devworks.entities.FavoriteFood;

public interface FavoriteFoodRepository extends JpaRepository<FavoriteFood, Long>
{
	FavoriteFood getFoodByFoodID(Long id);
}
