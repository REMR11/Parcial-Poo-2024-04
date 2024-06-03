package com.parcialpoo.ufg.MR100823.models;

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

/**
 * Clase que representa un cliente.
 */
@Entity
@Table(name = "COSTUMER")
public class Costumer {

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costumer_Id;

    /**
     * Nombre del cliente.
     */
    private String name;

    /**
     * Email del cliente.
     */
    private String email;

    /**
     * Contraseña del cliente.
     */
    private String password;

    /**
     * Número de teléfono del cliente.
     */
    @Column(length = 11)
    private Integer phone;

    /**
     * Lista de reservaciones del cliente.
     */
    @OneToMany(mappedBy = "costumer")
    private List<Reservation> reservaciones;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderCostumer order;
    /**
     * Constructor por defecto.
     */
    public Costumer() {}

    
    /**
	 * @param costumer_Id
	 * @param name
	 * @param email
	 * @param password
	 * @param phone
	 */
	public Costumer(String name, String email, String password, int phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}


	/**
	 * @param costumer_Id
	 * @param name
	 * @param email
	 * @param password
	 * @param phone
	 * @param reservaciones
	 * @param order
	 */
	public Costumer(Integer costumer_Id, String name, String email, String password, Integer phone,
			List<Reservation> reservaciones, OrderCostumer order) {
		super();
		this.costumer_Id = costumer_Id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.reservaciones = reservaciones;
		this.order = order;
	}



	public Integer getCostumer_Id() {
        return costumer_Id;
    }

    public void setCostumer_Id(Integer costumer_Id) {
        this.costumer_Id = costumer_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public List<Reservation> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(List<Reservation> reservaciones) {
        this.reservaciones = reservaciones;
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


    @Override
	public int hashCode() {
		return Objects.hash(costumer_Id, email, name, order, password, phone, reservaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costumer other = (Costumer) obj;
		return Objects.equals(costumer_Id, other.costumer_Id) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(order, other.order)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(reservaciones, other.reservaciones);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Costumer [");
		if (costumer_Id != null) {
			builder.append("costumer_Id=");
			builder.append(costumer_Id);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}
		if (phone != null) {
			builder.append("phone=");
			builder.append(phone);
			builder.append(", ");
		}
		if (reservaciones != null) {
			builder.append("reservaciones=");
			builder.append(reservaciones);
			builder.append(", ");
		}
		if (order != null) {
			builder.append("order=");
			builder.append(order);
		}
		builder.append("]");
		return builder.toString();
	}

	

}