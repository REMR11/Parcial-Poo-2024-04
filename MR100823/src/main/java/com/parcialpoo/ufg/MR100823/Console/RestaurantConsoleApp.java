package com.parcialpoo.ufg.MR100823.Console;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Menu;
import com.parcialpoo.ufg.MR100823.models.Reservation;
import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.models.TableRestaurant;
import com.parcialpoo.ufg.MR100823.services.MenuService;
import com.parcialpoo.ufg.MR100823.services.ReservationService;
import com.parcialpoo.ufg.MR100823.services.RestaurantService;
import com.parcialpoo.ufg.MR100823.services.TableRestaurantService;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de restaurantes.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar restaurantes,
 * utilizando el servicio de restaurantes proporcionado por
 * {@link RestaurantService}.
 * 
 * @author remr1
 */
@Component
public class RestaurantConsoleApp {
	private static RestaurantService restaurantService;
	private static ReservationService reservationService;
	private static TableRestaurantService tableRestaurantService;
	private static MenuService menuService;

	/**
	 * Método principal de la aplicación de consola de restaurantes que muestra un
	 * menú para interactuar con la gestión de restaurantes.
	 */
	public static void restaurantConsoleAppMain() {
		restaurantService = new RestaurantService();
		reservationService = new ReservationService();
		tableRestaurantService = new TableRestaurantService();
		menuService = new MenuService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Restaurantes:");
			System.out.println("1. Crear restaurante");
			System.out.println("2. Leer restaurantes");
			System.out.println("3. Actualizar restaurante");
			System.out.println("4. Eliminar restaurante");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createRestaurant(scanner);
				break;
			case 2:
				readRestaurants();
				break;
			case 3:
				updateRestaurant(scanner);
				break;
			case 4:
				deleteRestaurant(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea un nuevo restaurante solicitando la información necesaria al
	 * usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void createRestaurant(Scanner scanner) {
		Restaurant restaurant = new Restaurant();
		collectionData(restaurant, scanner);
		restaurantService.saveRestaurant(restaurant);
		System.out.println("Restaurante creado exitosamente!");
	}

	/**
	 * Método que muestra la lista de todos los restaurantes existentes.
	 */
	private static void readRestaurants() {
		List<Restaurant> restaurants = restaurantService.showAll();
		for (Restaurant restaurant : restaurants) {
			System.out.println(restaurant.toString());
		}
	}

	/**
	 * Método que actualiza la información de un restaurante existente solicitando
	 * la nueva información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateRestaurant(Scanner scanner) {
		int restaurantId =Validator.getId(scanner);
		Restaurant restaurant = restaurantService.FindById(restaurantId);
		collectionData(restaurant, scanner);
		restaurantService.saveRestaurant(restaurant);
		restaurantService.saveRestaurant(restaurant);

		System.out.println("Restaurante actualizado exitosamente!");
	}

	/**
	 * Método que elimina un restaurante existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteRestaurant(Scanner scanner) {
		System.out.print("Ingrese el ID del restaurante a eliminar: ");
		int restaurantId = scanner.nextInt();
		Restaurant restaurant = restaurantService.FindById(restaurantId);
		restaurantService.deleteRestaurant(restaurant);

		System.out.println("Restaurante eliminado exitosamente!");
	}

	private static void collectionData(Restaurant restaurant, Scanner scanner) {
		restaurant.setName(Validator.getName(scanner));
		restaurant.setAddress(Validator.getAddress(scanner));
		restaurant.setPhoneNumber(Validator.getPhoneNumber());

		System.out.println("Mesas:");
		List<TableRestaurant> tableRestaurants = new ArrayList<>();
		System.out.println(tableRestaurantService.showAll());
		while (true) {
			System.out.print("Ingrese el ID de la mesa (0 para terminar): ");
			int id = scanner.nextInt();
			if (id == 0) {
				break;
			}

			TableRestaurant tableRestaurant = tableRestaurantService.FindById(id);

			tableRestaurants.add(tableRestaurant);
		}

		System.out.println("reservaciones:");
		List<Reservation> reservations = new ArrayList<>();
		System.out.println(reservationService.showAll());
		while (true) {
			System.out.print("Ingrese el ID de la reservacion (0 para terminar): ");
			int id = scanner.nextInt();
			if (id == 0) {
				break;
			}

			Reservation reservation = reservationService.FindById(id);

			reservations.add(reservation);
		}

		System.out.println("Menus:");
		List<Menu> menus = new ArrayList<>();
		System.out.println(menuService.showAll());
		while (true) {
			System.out.print("Ingrese el ID del menu (0 para terminar): ");
			int id = scanner.nextInt();
			if (id == 0) {
				break;
			}

			Menu menu = menuService.FindById(id);

			menus.add(menu);
		}
	}
}