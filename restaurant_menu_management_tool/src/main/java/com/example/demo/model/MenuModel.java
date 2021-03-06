package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")

public class MenuModel {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "title")
	private String title;
	@Column(name= "category")
	private String category;
	@Column(name= "price")
	private float price;
	@Column(name="image")
	private String image;
	@Column(name="description")
	private String description;
	
	
	public MenuModel()
    {
    	
    }
	
	public MenuModel(int id, String title, String category, float price, String image, String description) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.image = image;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
