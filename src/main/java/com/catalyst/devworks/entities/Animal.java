package com.catalyst.devworks.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="animal", catalog="zookeepr")
public class Animal implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "animalID", unique=true)
	private long animalID;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "common_name")
	private String commonName;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "scientific_name", unique=true)
	private String scientificName;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "foodID")
	private FavoriteFood favoriteFood;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "info_link")
	private String infoLink;
	
	public Long getAnimalID()
	{
		return this.animalID;
	}
	public void setAnimalID(Long animalID)
	{
		this.animalID = animalID;
	}
	public String getCommonName()
	{
		return this.commonName;
	}
	public void setCommonName(String commonName)
	{
		this.commonName = commonName;
	}
	public String getScientificName()
	{
		return this.scientificName;
	}
	public void setScientificName(String scientificName)
	{
		this.scientificName = scientificName;
	}
	public FavoriteFood getFavoriteFood()
	{
		return this.favoriteFood;
	}
	public void setFavoriteFood(FavoriteFood favoriteFood)
	{
		this.favoriteFood = favoriteFood;
	}
	public String getInfoLink()
	{
		return this.infoLink;
	}
	public void setInfoLink(String infoLink)
	{
		this.infoLink = infoLink;
	}
}