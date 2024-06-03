package com.parcialpoo.ufg.MR100823.models;

import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * clase que representa una reservación
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation {

	/**
	 * Identificador único de la reservación.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservation_Id;

	/**
	 * Fecha y hora de la reservación.
	 */
	private LocalTime reservation_date;

	/**
	 * Precio total de la reservación.
	 */
	@Column(nullable = false, precision = 10)
	private float total_price;

	/**
	 * Estado de la reservación.
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	/**
	 * Cliente asociado a la reservación.
	 */
	@ManyToOne
	@JoinColumn(name = "costumer_Id")
	private Costumer costumer;

	/**
	 * restaurante asociado a la reservación.
	 */
	@ManyToOne
	@JoinColumn(name = "restaurant_Id")
	private Restaurant restaurant;

	/**
	 * @return the reservation_Id
	 */
	public Integer getReservation_Id() {
		return reservation_Id;
	}

	/**
	 * @param reservation_Id the reservation_Id to set
	 */
	public void setReservation_Id(Integer reservation_Id) {
		this.reservation_Id = reservation_Id;
	}

	/**
	 * @return the reservation_date
	 */
	public LocalTime getReservation_date() {
		return reservation_date;
	}

	/**
	 * @param reservation_date the reservation_date to set
	 */
	public void setReservation_date(LocalTime reservation_date) {
		this.reservation_date = reservation_date;
	}

	/**
	 * @return the total_price
	 */
	public float getTotal_price() {
		return total_price;
	}

	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the costumer
	 */
	public Costumer getCostumer() {
		return costumer;
	}

	/**
	 * @param costumer the costumer to set
	 */
	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
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

	@Override
	public int hashCode() {
		return Objects.hash(costumer, reservation_Id, reservation_date, status, total_price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(costumer, other.costumer) && Objects.equals(reservation_Id, other.reservation_Id)
				&& Objects.equals(reservation_date, other.reservation_date) && status == other.status
				&& Float.floatToIntBits(total_price) == Float.floatToIntBits(other.total_price);
	}

	/**
	 * Enum que representa los diferentes estados de una reservación.
	 */
	public enum Status {
		PENDING, CONFIRMED, CANCELLED
	}

	/**
	 * Constructor por defecto.
	 */
	public Reservation() {
	}

	/**
	 * Constructor con todos los atributos.
	 *
	 * @param reservation_Id   Identificador único de la reservación.
	 * @param reservation_date Fecha y hora de la reservación.
	 * @param total_price      Precio total de la reservación.
	 * @param status           Estado de la reservación.
	 * @param costumer         Cliente asociado a la reservación.
	 * @param restaurant       Restaurante asociado a la reservación.
	 */
	public Reservation(LocalTime reservation_date, float total_price, Status status, Costumer costumer,
			Restaurant restaurant) {
		this.reservation_date = reservation_date;
		this.total_price = total_price;
		this.status = status;
		this.costumer = costumer;
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [");
		if (reservation_Id != null) {
			builder.append("reservation_Id=");
			builder.append(reservation_Id);
			builder.append(", ");
		}
		if (reservation_date != null) {
			builder.append("reservation_date=");
			builder.append(reservation_date);
			builder.append(", ");
		}
		builder.append("total_price=");
		builder.append(total_price);
		builder.append(", ");
		if (status != null) {
			builder.append("status=");
			builder.append(status);
			builder.append(", ");
		}
		if (costumer != null) {
			builder.append("costumer=");
			builder.append(costumer);
			builder.append(", ");
		}
		if (restaurant != null) {
			builder.append("restaurant=");
			builder.append(restaurant);
		}
		builder.append("]");
		return builder.toString();
	}

}
