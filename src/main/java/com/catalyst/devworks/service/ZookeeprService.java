package com.catalyst.devworks.service;

import java.util.List;

import com.catalyst.devworks.entities.Animal;
import com.catalyst.devworks.entities.Enclosure;
import com.catalyst.devworks.entities.FavoriteFood;

public interface ZookeeprService 
{
	List<Enclosure> getAllEnclosures();
	Enclosure getEnclosureByID(Long id);
	Enclosure updateEnclosure(Enclosure enclosure);
	Enclosure createEnclosure(Enclosure enclosure);
	void deleteEnclosure(Long id);
	
	List<Animal> getAllAnimals();
	Animal getAnimalByID(Long id);
	Animal updateAnimal(Animal animal);
	Animal createAnimal(Animal animal);
	
	List<FavoriteFood> getFood();
	FavoriteFood getFoodByID(Long id);
	FavoriteFood updateFood(FavoriteFood food);
	FavoriteFood createFood(FavoriteFood food);
}
