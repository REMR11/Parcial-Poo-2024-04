package com.parcialpoo.ufg.MR100823.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Clase que representa un plato de comida
 */
@Entity
@Table(name = "FOOD_PLATE")
public class FoodPlate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodPlate_id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private boolean availability;

	@ManyToOne
	@JoinColumn(name = "menu_Id")
	private Menu menu;

	@ManyToOne
	@JoinColumn(name = "oder_Id")
	
	private OrderCostumer order;
	
	@OneToMany(mappedBy = "foodPlate")
	private List<Ingredient> ingredients;
	/**
	 * @return the foodPlate_id
	 */
	public int getFoodPlate_id() {
		return foodPlate_id;
	}

	/**
	 * @param foodPlate_id the foodPlate_id to set
	 */
	public void setFoodPlate_id(int foodPlate_id) {
		this.foodPlate_id = foodPlate_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the availability
	 */
	public boolean isAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodPlate [foodPlate_id=");
		builder.append(foodPlate_id);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		builder.append("price=");
		builder.append(price);
		builder.append(", availability=");
		builder.append(availability);
		builder.append(", ");
		if (menu != null) {
			builder.append("menu=");
			builder.append(menu);
		}
		builder.append("]");
		return builder.toString();
	}

	public FoodPlate() {
	}

	
	
	/**
	 * @param name
	 * @param description
	 * @param price
	 * @param availability
	 * @param menu
	 * @param ingredients
	 */
	public FoodPlate(String name, String description, float price, boolean availability, List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.availability = availability;
		this.ingredients = ingredients;
	}

	/**
	 * @param foodPlate_id
	 * @param name
	 * @param description
	 * @param price
	 * @param availability
	 * @param ingredients
	 */
	public FoodPlate(int foodPlate_id, String name, String description, float price, boolean availability,
			List<Ingredient> ingredients) {
		super();
		this.foodPlate_id = foodPlate_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availability = availability;
		this.ingredients = ingredients;
	}

}
