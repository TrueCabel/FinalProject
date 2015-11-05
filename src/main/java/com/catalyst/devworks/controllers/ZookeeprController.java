package com.catalyst.devworks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.devworks.entities.Animal;
import com.catalyst.devworks.entities.Enclosure;
import com.catalyst.devworks.entities.FavoriteFood;
import com.catalyst.devworks.service.ZookeeprService;
import com.catalyst.devworks.service.impl.ZookeeprServiceImpl;

/**
 * REST Controller used by the Front-End of the Application
 * to request for view, alter, and delete data from the database.
 */
@RestController
@RequestMapping(value="/api")
public class ZookeeprController 
{
	ZookeeprService zooService;
	
	@Autowired
	public ZookeeprController(ZookeeprServiceImpl zooService)
	{
		this.zooService = zooService;
	}
	
	@RequestMapping(value="/enclosure/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Enclosure> getAllEnclosures()
	{
		return zooService.getAllEnclosures();
	}
	
	@RequestMapping(value="/enclosure/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Enclosure getEnclosureByID(@RequestParam Long id)
	{
		return zooService.getEnclosureByID(id);
	}
	
	@RequestMapping(value="/enclosure/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Enclosure updateEnclosureByID(@RequestParam Enclosure enclosure)
	{
		return zooService.updateEnclosure(enclosure);
	}
	
	@RequestMapping(value="/enclosure", method = RequestMethod.POST)
	@ResponseBody
	public Enclosure createEnclosure(@RequestParam Enclosure enclosure)
	{
		return zooService.createEnclosure(enclosure);
	}
	
	@RequestMapping(value="/enclosure", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEnclosureByID(@RequestParam Long id)
	{
		zooService.deleteEnclosure(id);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/animals/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Animal> getAllAnimals()
	{
		return zooService.getAllAnimals();
	}
	
	@RequestMapping(value="/animals/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Animal getAnimalsByID(@RequestParam Long id)
	{
		return zooService.getAnimalByID(id);
	}
	
	@RequestMapping(value="/animals/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Animal updateAnimalByID(@RequestParam Animal animal)
	{
		return zooService.updateAnimal(animal);
	}
	
	@RequestMapping(value="/animals", method = RequestMethod.POST)
	@ResponseBody
	public Animal createAnimal(@RequestParam Animal animal)
	{
		return zooService.createAnimal(animal);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/food/all", method = RequestMethod.GET)
	@ResponseBody
	public List<FavoriteFood> getAllFood()
	{
		return zooService.getFood();
	}
	
	@RequestMapping(value="/food/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FavoriteFood getFoodByID(@RequestParam Long id)
	{
		return zooService.getFoodByID(id);
	}
	
	@RequestMapping(value="/food/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public FavoriteFood updateFoodByID(@RequestParam FavoriteFood food)
	{
		return zooService.updateFood(food);
	}
	
	@RequestMapping(value="/food", method = RequestMethod.POST)
	@ResponseBody
	public FavoriteFood createFood(@RequestParam FavoriteFood food)
	{
		return zooService.createFood(food);
	}
}
