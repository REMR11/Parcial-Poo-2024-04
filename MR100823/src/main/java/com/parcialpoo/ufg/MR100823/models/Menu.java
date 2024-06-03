package com.parcialpoo.ufg.MR100823.models;

import java.util.List;
import java.util.Objects;

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
 * Clase que representa un menú de un restaurante.
 */
@Entity
@Table(name = "MENU")
public class Menu {

	/**
	 * Identificador único del menú.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menu_Id;

	/**
	 * Nombre del menú.
	 */
	@Column(length = 60)
	private String name;

	/**
	 * Descripción del menú.
	 */
	@Column(length = 255)
	private String description;

	/**
	 * Precio del menú.
	 */
	private int price;

	/**
	 * Restaurante al que pertenece el menú.
	 */
	@ManyToOne
	@JoinColumn(name = "restaurant_Id")
	private Restaurant restaurant;

	/**
	 * Restaurante al que pertenece la mesa.
	 */
	@OneToMany(mappedBy = "menu")
	private List<TableRestaurant> tables;

	/**
	 * Platillos que contiene el menu
	 */
	@OneToMany(mappedBy = "menu")
	private List<FoodPlate> foodPlates;

	/**
	 * Constructor por defecto.
	 */
	public Menu() {
	}

	/**
	 * Constructor con todos los atributos.
	 *
	 * @param menu_Id     Identificador único del menú.
	 * @param name        Nombre del menú.
	 * @param description Descripción del menú.
	 * @param price       Precio del menú.
	 * @param restaurant  Restaurante al que pertenece el menú.
	 */
	public Menu(String name, String description, int price, Restaurant restaurant) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.restaurant = restaurant;
	}

	// Getters and setters

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + menu_Id;
		result = prime * result + Objects.hash(name, description, price, restaurant);
		return result;
	}

	/**
	 * @return the menu_Id
	 */
	public int getMenu_Id() {
		return menu_Id;
	}

	/**
	 * @param menu_Id the menu_Id to set
	 */
	public void setMenu_Id(int menu_Id) {
		this.menu_Id = menu_Id;
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
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * @param restaurant the restaurant to set
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * @return the tables
	 */
	public List<TableRestaurant> getTables() {
		return tables;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(List<TableRestaurant> tables) {
		this.tables = tables;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return menu_Id == other.menu_Id && Objects.equals(name, other.name)
				&& Objects.equals(description, other.description) && price == other.price
				&& Objects.equals(restaurant, other.restaurant);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Menu [menu_Id=");
		builder.append(menu_Id);
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
		builder.append(", ");
		if (restaurant != null) {
			builder.append("restaurant=");
			builder.append(restaurant);
			builder.append(", ");
		}
		if (tables != null) {
			builder.append("tables=");
			builder.append(tables);
			builder.append(", ");
		}
		if (foodPlates != null) {
			builder.append("foodPlates=");
			builder.append(foodPlates);
		}
		builder.append("]");
		return builder.toString();
	}

}