package com.parcialpoo.ufg.MR100823.models;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_Id;
	
	@OneToOne(mappedBy = "payment")
	private OrderCostumer order;
	
	private Payment_method paymentMethod;
	
	private Time paymentDate;
	
	private int amount;
	
	private Status status;
	
	public enum Payment_method{
		TARJETA, EFECTIVO
	}
	
	public enum Status{
		PENDING, APPROVED, REJECTED
	}

	/**
	 * @return the payment_Id
	 */
	public int getPayment_Id() {
		return payment_Id;
	}

	/**
	 * @param payment_Id the payment_Id to set
	 */
	public void setPayment_Id(int payment_Id) {
		this.payment_Id = payment_Id;
	}

	/**
	 * @return the order
	 */
	public OrderCostumer getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderCostumer order) {
		this.order = order;
	}

	/**
	 * @return the paymentMethod
	 */
	public Payment_method getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(Payment_method paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the paymentDate
	 */
	public Time getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Time paymentDate) {
		this.paymentDate = paymentDate;
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
	public Payment() {
		super();
	}

	/**
	 * @param payment_Id
	 * @param order
	 * @param paymentMethod
	 * @param paymentDate
	 * @param amount
	 * @param status
	 */
	public Payment(OrderCostumer order, Payment_method paymentMethod, Time paymentDate, int amount,
			Status status) {
		super();
		this.order = order;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [payment_Id=");
		builder.append(payment_Id);
		builder.append(", ");
		if (order != null) {
			builder.append("order=");
			builder.append(order);
			builder.append(", ");
		}
		if (paymentMethod != null) {
			builder.append("paymentMethod=");
			builder.append(paymentMethod);
			builder.append(", ");
		}
		if (paymentDate != null) {
			builder.append("paymentDate=");
			builder.append(paymentDate);
			builder.append(", ");
		}
		builder.append("amount=");
		builder.append(amount);
		builder.append(", ");
		if (status != null) {
			builder.append("status=");
			builder.append(status);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
