package com.catalyst.devworks.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.devworks.entities.Animal;
import com.catalyst.devworks.entities.Enclosure;
import com.catalyst.devworks.entities.FavoriteFood;
import com.catalyst.devworks.repository.AnimalRepository;
import com.catalyst.devworks.repository.EnclosureRepository;
import com.catalyst.devworks.repository.FavoriteFoodRepository;
import com.catalyst.devworks.service.ZookeeprService;

@Service
public class ZookeeprServiceImpl implements ZookeeprService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeprServiceImpl.class);
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private EnclosureRepository enclosureRepository;
	
	@Autowired
	private FavoriteFoodRepository foodRepository;
	
	public void setAnimalRepository(AnimalRepository animals) 
	{
		this.animalRepository = animals;
		LOGGER.info(this.animalRepository.toString());
	}
	public void setEnclosureRepository(EnclosureRepository enclosures) 
	{
		this.enclosureRepository = enclosures;
		LOGGER.info(this.enclosureRepository.toString());
	}
	public void setFoodRepository(FavoriteFoodRepository foods) 
	{
		this.foodRepository = foods;
		LOGGER.info(this.foodRepository.toString());
	}

	@Override
	public List<Enclosure> getAllEnclosures() 
	{
		LOGGER.info("---Retreiving All Enclosures---");
		return enclosureRepository.findAll();
	}

	@Override
	public Enclosure getEnclosureByID(Long id) 
	{
		LOGGER.info("---Retreiving Enclosure " + id + "---");
		return enclosureRepository.getEnclosureByEnclosureID(id);
	}
	
	@Override
	public Enclosure updateEnclosure(Enclosure enclosure)
	{
		LOGGER.info("---Updating Enclosure " + enclosure.getEnclosureID() + "---");
		return enclosureRepository.save(enclosure);
	}
	
	@Override
	public Enclosure createEnclosure(Enclosure enclosure)
	{
		// TODO Validation before actually saving
		LOGGER.info("---Creating New Enclosure---");
		return enclosureRepository.save(enclosure);
	}
	
	@Override
	public void deleteEnclosure(Long id)
	{
		LOGGER.info("---Deleting Enclosure " + id + "---");
		enclosureRepository.delete(id);
	}

	@Override
	public List<Animal> getAllAnimals() 
	{
		LOGGER.info("---Retreiving All Animals---");
		return animalRepository.findAll();
	}

	@Override
	public Animal getAnimalByID(Long id) 
	{
		LOGGER.info("---Retreiving Animal " + id + "---");
		return animalRepository.getAnimalByAnimalID(id);
	}
	
	@Override
	public Animal updateAnimal(Animal animal)
	{
		LOGGER.info("---Updating Animal " + animal.getAnimalID() + "---");
		return animalRepository.save(animal);
	}
	
	@Override
	public Animal createAnimal(Animal animal)
	{
		// TODO Validation before actually saving
		LOGGER.info("---Creating New Animal---");
		return animalRepository.save(animal);
	}

	@Override
	public List<FavoriteFood> getFood() 
	{
		LOGGER.info("---Retreiving All Food Items---");
		return foodRepository.findAll();
	}

	@Override
	public FavoriteFood getFoodByID(Long id) 
	{
		LOGGER.info("---Retreiving Food Item " + id + "---");
		return foodRepository.getFoodByFoodID(id);
	}
	
	@Override
	public FavoriteFood updateFood(FavoriteFood food)
	{
		LOGGER.info("---Updating Food Item " + food.getFoodID() + "---");
		return foodRepository.save(food);
	}
	
	@Override
	public FavoriteFood createFood(FavoriteFood food)
	{
		// TODO Validation before actually saving
		LOGGER.info("---Creating New Food Item---");
		return foodRepository.save(food);
	}
}
