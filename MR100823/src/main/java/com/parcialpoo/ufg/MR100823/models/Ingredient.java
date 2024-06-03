package com.parcialpoo.ufg.MR100823.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INGREDINT")
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingredient_id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private float price;
	
	@Column(nullable = false)
	private int amount;

	@ManyToOne
	@JoinColumn(name = "foodPlate_id")
	private FoodPlate foodPlate;
	/**
	 * @return the ingredient_id
	 */
	public int getIngredient_id() {
		return ingredient_id;
	}

	/**
	 * @param ingredient_id the ingredient_id to set
	 */
	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
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
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	/**
	 * @return the foodPlate
	 */
	public FoodPlate getFoodPlate() {
		return foodPlate;
	}

	/**
	 * @param foodPlate the foodPlate to set
	 */
	public void setFoodPlate(FoodPlate foodPlate) {
		this.foodPlate = foodPlate;
	}

	public Ingredient() {
		super();
	}

	
	/**
	 * @param ingredient_id
	 * @param name
	 * @param description
	 * @param price
	 * @param amount
	 */
	public Ingredient(String name, String description, float price, int amount) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.amount = amount;
	}

	/**
	 * @param ingredient_id
	 * @param name
	 * @param description
	 * @param price
	 * @param amount
	 * @param foodPlate
	 */
	public Ingredient(int ingredient_id, String name, String description, float price, int amount,
			FoodPlate foodPlate) {
		super();
		this.ingredient_id = ingredient_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.amount = amount;
		this.foodPlate = foodPlate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, description, foodPlate, ingredient_id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		return amount == other.amount && Objects.equals(description, other.description)
				&& Objects.equals(foodPlate, other.foodPlate) && ingredient_id == other.ingredient_id
				&& Objects.equals(name, other.name) && Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [ingredient_id=");
		builder.append(ingredient_id);
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
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", ");
		if (foodPlate != null) {
			builder.append("foodPlate=");
			builder.append(foodPlate);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
