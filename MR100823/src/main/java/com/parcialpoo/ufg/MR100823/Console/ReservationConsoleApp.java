package com.parcialpoo.ufg.MR100823.Console;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.models.Reservation;
import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.services.ReservationService;
import com.parcialpoo.ufg.MR100823.services.CostumerService;
import com.parcialpoo.ufg.MR100823.services.RestaurantService;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de reservaciones.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar reservaciones,
 * utilizando los servicios de reservaciones, clientes y restaurantes
 * proporcionados por {@link ReservationService}, {@link CostumerService} y
 * {@link RestaurantService}.
 * 
 * @author [Tu nombre]
 */
@Component
public class ReservationConsoleApp {
	private static ReservationService reservationService;
	private static CostumerService costumerService;
	private static RestaurantService restaurantService;

	/**
	 * Clase que proporciona una interfaz de consola para interactuar con la gestión
	 * de reservaciones.
	 * 
	 * Esta clase permite crear, leer, actualizar y eliminar reservaciones,
	 * utilizando los servicios de reservaciones, clientes y restaurantes
	 * proporcionados por {@link ReservationService}, {@link CostumerService} y
	 * {@link RestaurantService}.
	 * 
	 * @author [Tu nombre]
	 */
	public static void reservationConsoleAppMain() {
		reservationService = new ReservationService();
		costumerService = new CostumerService();
		restaurantService = new RestaurantService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Reservaciones:");
			System.out.println("1. Crear reservación");
			System.out.println("2. Leer reservaciones");
			System.out.println("3. Actualizar reservación");
			System.out.println("4. Eliminar reservación");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createReservation(scanner);
				break;
			case 2:
				readReservations();
				break;
			case 3:
				updateReservation(scanner);
				break;
			case 4:
				deleteReservation(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea una nueva reservación solicitando la información necesaria al
	 * usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void createReservation(Scanner scanner) {
		System.out.print("Ingrese el ID del cliente: ");
		int costumerId = scanner.nextInt();
		Costumer costumer = costumerService.FindById(costumerId);

		System.out.print("Ingrese el ID del restaurante: ");
		int restaurantId = scanner.nextInt();
		Restaurant restaurant = restaurantService.FindById(restaurantId);

		System.out.print("Ingrese la fecha y hora de la reservación (HH:mm): ");
		String reservationDateStr = scanner.next();
		LocalTime reservationDate = LocalTime.parse(reservationDateStr);

		System.out.print("Ingrese el precio total de la reservación: ");
		float totalPrice = scanner.nextFloat();

		Reservation.Status statusEnum = Reservation.Status.PENDING;

		Reservation reservation = new Reservation(reservationDate, totalPrice, statusEnum, costumer, restaurant);
		reservationService.saveReservation(reservation);

		System.out.println("Reservación creada exitosamente!");
	}

	/**
	 * Método que muestra la lista de todas las reservaciones existentes.
	 */
	private static void readReservations() {
		List<Reservation> reservations = reservationService.showAll();
		for (Reservation reservation : reservations) {
			System.out.println(reservation.toString());
		}
	}

	/**
	 * Método que actualiza la información de una reservación existente solicitando
	 * la nueva información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateReservation(Scanner scanner) {
		System.out.print("Ingrese el ID de la reservación a actualizar: ");
		int reservationId = scanner.nextInt();
		Reservation reservation = reservationService.FindById(reservationId);

		System.out.print("Ingrese la nueva fecha y hora de la reservación (HH:mm): ");
		String reservationDateStr = scanner.next();
		reservation.setReservation_date(LocalTime.parse(reservationDateStr));

		System.out.print("Ingrese el nuevo precio total de la reservación: ");
		float totalPrice = scanner.nextFloat();
		reservation.setTotal_price(totalPrice);

		System.out.print("Ingrese el nuevo estado de la reservación (PENDING, CONFIRMED, CANCELLED): ");
		String statusStr = scanner.next();
		reservation.setStatus(statusStr.equals("PENDING") ? Reservation.Status.PENDING
				: statusStr.equals("CONFIRMED") ? Reservation.Status.CONFIRMED : Reservation.Status.CANCELLED);

		reservationService.saveReservation(reservation);

		System.out.println("Reservación actualizada exitosamente!");
	}

	/**
	 * Método que elimina una reservación existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteReservation(Scanner scanner) {
		System.out.println(reservationService.showAll() + "\n");
		System.out.print("Ingrese el ID de la reservación a eliminar: ");
		int reservationId = scanner.nextInt();
		Reservation reservation = reservationService.FindById(reservationId);
		reservationService.deleteReservation(reservation);

		System.out.println("Reservación eliminada exitosamente!");
	}
}