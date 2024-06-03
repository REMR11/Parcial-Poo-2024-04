package com.parcialpoo.ufg.MR100823.models;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_COSTUMER")
public class OrderCostumer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_Id;

	@OneToOne(mappedBy = "order")
	private Costumer costumer;

	@OneToMany(mappedBy = "order")
	private List<FoodPlate> plates;

	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;

	@Column(nullable = false)
	private Time orderDate;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private float totalPrice;

	private Status status;

	/**
	 * @return the order_Id
	 */
	public int getOrder_Id() {
		return order_Id;
	}

	/**
	 * @param order_Id the order_Id to set
	 */
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
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
	 * @return the plates
	 */
	public List<FoodPlate> getPlates() {
		return plates;
	}

	/**
	 * @param plates the plates to set
	 */
	public void setPlates(List<FoodPlate> plates) {
		this.plates = plates;
	}

	/**
	 * @return the orderDate
	 */
	public Time getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Time orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
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
	 * 
	 */
	public OrderCostumer() {
		super();
	}

	/**
	 * @param costumer
	 * @param plates
	 * @param payment
	 * @param orderDate
	 * @param quantity
	 * @param totalPrice
	 * @param status
	 */
	public OrderCostumer(Costumer costumer, List<FoodPlate> plates, Time orderDate, int quantity, float toatlPrice,
			Status status) {
		super();
		this.costumer = costumer;
		this.plates = plates;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.totalPrice = toatlPrice;
		this.status = status;
	}

	/**
	 * @param order_Id
	 * @param costumer
	 * @param plates
	 * @param payment
	 * @param orderDate
	 * @param quantity
	 * @param totalPrice
	 * @param status
	 */
	public OrderCostumer(int order_Id, Costumer costumer, List<FoodPlate> plates, Payment payment, Time orderDate,
			int quantity, float totalPrice, Status status) {
		super();
		this.order_Id = order_Id;
		this.costumer = costumer;
		this.plates = plates;
		this.payment = payment;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costumer, orderDate, order_Id, payment, plates, quantity, status, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderCostumer other = (OrderCostumer) obj;
		return Objects.equals(costumer, other.costumer) && Objects.equals(orderDate, other.orderDate)
				&& order_Id == other.order_Id && Objects.equals(payment, other.payment)
				&& Objects.equals(plates, other.plates) && quantity == other.quantity && status == other.status
				&& Float.floatToIntBits(totalPrice) == Float.floatToIntBits(other.totalPrice);
	}

	/**
	 * Enum que representa los diferentes estados de una orden.
	 */
	public enum Status {
		PENDING, PREPARING, READY, DELIVRED
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderCostumer [order_Id=");
		builder.append(order_Id);
		builder.append(", ");
		if (costumer != null) {
			builder.append("costumer=");
			builder.append(costumer);
			builder.append(", ");
		}
		if (plates != null) {
			builder.append("plates=");
			builder.append(plates);
			builder.append(", ");
		}
		if (payment != null) {
			builder.append("payment=");
			builder.append(payment);
			builder.append(", ");
		}
		if (orderDate != null) {
			builder.append("orderDate=");
			builder.append(orderDate);
			builder.append(", ");
		}
		builder.append("quantity=");
		builder.append(quantity);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", ");
		if (status != null) {
			builder.append("status=");
			builder.append(status);
		}
		builder.append("]");
		return builder.toString();
	}

}
