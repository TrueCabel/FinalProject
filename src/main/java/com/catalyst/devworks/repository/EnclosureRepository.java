package com.catalyst.devworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.devworks.entities.Enclosure;

public interface EnclosureRepository extends JpaRepository<Enclosure, Long> 
{
	Enclosure getEnclosureByEnclosureID(Long id);
}
