package com.parcialpoo.ufg.MR100823.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa una mesa de un restaurante.
 */
@Entity
@Table(name = "TABLE_RESTAURANT")
public class TableRestaurant {

	/**
	 * Identificador único de la mesa.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int table_Id;

	/**
	 * Capacidad de la mesa.
	 */
	@Column(length = 2)
	private int capacity;

	/**
	 * Descripción de la mesa.
	 */
	@Column(length = 200)
	private String description;

	/**
	 * Tema de la mesa.
	 */
	@Column(length = 20)
	private String topic;

	/**
	 * Estado de la mesa.
	 */
	private boolean status;

	/**
	 * Restaurante al que pertenece la mesa.
	 */
	@ManyToOne
	@JoinColumn(name = "restaurant_Id")
	private Restaurant restaurant;

	/**
	 * Restaurante al que pertenece la mesa.
	 */
	@ManyToOne
	@JoinColumn(name = "menu_Id")
	private Menu menu;

	/**
	 * Constructor por defecto.
	 */
	public TableRestaurant() {
	}

	/**
	 * Constructor con todos los atributos.
	 *
	 * @param capacity    Capacidad de la mesa.
	 * @param description Descripción de la mesa.
	 * @param topic       Tema de la mesa.
	 * @param status      Estado de la mesa.
	 * @param restaurant  Restaurante al que pertenece la mesa.
	 */
	public TableRestaurant(int capacity, String description, String topic, boolean status, Restaurant restaurant) {
		this.capacity = capacity;
		this.description = description;
		this.topic = topic;
		this.status = status;
		this.restaurant = restaurant;
	}

	// Getters and setters

	public int getTable_Id() {
		return table_Id;
	}

	public void setTable_Id(int table_Id) {
		this.table_Id = table_Id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "TableRestaurant [table_Id=" + table_Id + ", capacity=" + capacity + ", description=" + description
				+ ", topic=" + topic + ", status=" + status + ", restaurant=" + restaurant + "]";
	}

}