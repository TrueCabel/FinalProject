package com.catalyst.devworks.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "favorite_food", catalog = "zookeepr")
public class FavoriteFood implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "foodID", unique=true)
	private long foodID;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "food_name", unique=true)
	private String foodName;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "vendor_name")
	private String vendorName;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "food_type")
	private FoodTypeEnum foodType;
	
	public Long getFoodID()
	{
		return this.foodID;
	}
	public void setFoodID(Long foodID)
	{
		this.foodID = foodID;
	}
	public String getFoodName()
	{
		return this.foodName;
	}
	public void setFoodName(String foodName)
	{
		this.foodName = foodName;
	}
	public String getVendorName()
	{
		return this.vendorName;
	}
	public void setVendorName(String vendorName)
	{
		this.vendorName = vendorName;
	}
	public FoodTypeEnum getFoodType()
	{
		return this.foodType;
	}
	public void setFoodType(FoodTypeEnum foodType)
	{
		this.foodType = foodType;
	}
}
