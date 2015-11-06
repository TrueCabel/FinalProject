package com.catalyst.devworks.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="animal_enclosure", catalog="zookeepr")
public class Enclosure implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enclosureID", unique=true)
	private long enclosureID;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "enclosure_name")
	private String enclosureName;
	
	@ManyToOne
	@JoinColumn(name = "animalID")
	private Animal animal;
	
	@NotNull
	@Column(name = "number_animals")
	private Integer numberOfAnimals;
	
	@NotNull
	@Column(name = "feeding_time")
	private Date feedingTime;
		
	@NotNull
	@Column(name = "enclosure_condition")
	private EnclosureConditionEnum enclosure_condition;
	
	public Long getEnclosureID()
	{
		return this.enclosureID;
	}
	public void setEnclosureID(Long enclosureID)
	{
		this.enclosureID = enclosureID;
	}
	public String getEnclosureName()
	{
		return this.enclosureName;
	}
	public void setEnclosureName(String enclosureName)
	{
		this.enclosureName = enclosureName;
	}
	public Animal getAnimal()
	{
		return this.animal;
	}
	public void setAnimal(Animal animal)
	{
		this.animal = animal;
	}
	public Integer getNumberOfAnimals()
	{
		return this.numberOfAnimals;
	}
	public void setNumberOfAnimals(Integer numberOfAnimals)
	{
		this.numberOfAnimals = numberOfAnimals;
	}
	public Date getFeedingTime()
	{
		return this.feedingTime;
	}
	public void setFeedingTime(Date feedingTime)
	{
		this.feedingTime = feedingTime;
	}
	public EnclosureConditionEnum getEnclosureCondition()
	{
		return this.enclosure_condition;
	}
	public void setEnclosureCondition(EnclosureConditionEnum enclosure_condition)
	{
		this.enclosure_condition = enclosure_condition;
	}
}
