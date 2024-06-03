package com.parcialpoo.ufg.MR100823.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Clase que representa un restaurante.
 */
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    /**
     * Identificador único del restaurante.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurant_Id;

    /**
     * Dirección del restaurante.
     */
    @Column(nullable = false)
    private String address;

    /**
     * Nombre del restaurante.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Número de teléfono del restaurante.
     */
    @Column(nullable = false)
    private int phoneNumber;

    /**
     * Lista de mesas del restaurante.
     */
    @OneToMany(mappedBy = "restaurant")
    private List<TableRestaurant> tables;

    /**
     * Lista de reservaciones del restaurante.
     */
    @OneToMany(mappedBy = "restaurant")
    private List<Reservation> reservations;

    /**
     * Lista de menús del restaurante.
     */
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

    /**
     * Constructor por defecto.
     */
    public Restaurant() {}

    /**
     * Constructor con todos los atributos.
     *
     * @param restaurant_Id Identificador único del restaurante.
     * @param address Dirección del restaurante.
     * @param name Nombre del restaurante.
     * @param phoneNumber Número de teléfono del restaurante.
     * @param tables Lista de mesas del restaurante.
     * @param reservations Lista de reservaciones del restaurante.
     * @param menus Lista de menús del restaurante.
     */
    public Restaurant(int restaurant_Id, String address, String name, int phoneNumber, List<TableRestaurant> tables, List<Reservation> reservations, List<Menu> menus) {
        this.restaurant_Id = restaurant_Id;
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.tables = tables;
        this.reservations = reservations;
        this.menus = menus;
    }

    // Getters and setters

    public int getRestaurant_Id() {
        return restaurant_Id;
    }

    public void setRestaurant_Id(int restaurant_Id) {
        this.restaurant_Id = restaurant_Id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<TableRestaurant> getTables() {
        return tables;
    }

    public void setTables(List<TableRestaurant> tables) {
        this.tables = tables;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant [restaurant_Id=");
		builder.append(restaurant_Id);
		builder.append(", ");
		if (address != null) {
			builder.append("address=");
			builder.append(address);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		builder.append("phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", ");
		if (tables != null) {
			builder.append("tables=");
			builder.append(tables);
			builder.append(", ");
		}
		if (reservations != null) {
			builder.append("reservations=");
			builder.append(reservations);
			builder.append(", ");
		}
		if (menus != null) {
			builder.append("menus=");
			builder.append(menus);
		}
		builder.append("]");
		return builder.toString();
	}



}