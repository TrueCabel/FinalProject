package com.catalyst.devworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.devworks.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> 
{
	Animal getAnimalByAnimalID(Long id);
}
