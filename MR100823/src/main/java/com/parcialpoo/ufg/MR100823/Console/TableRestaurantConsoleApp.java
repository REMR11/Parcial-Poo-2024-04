package com.parcialpoo.ufg.MR100823.Console;

import java.util.List;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.models.TableRestaurant;
import com.parcialpoo.ufg.MR100823.services.RestaurantService;
import com.parcialpoo.ufg.MR100823.services.TableRestaurantService;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de mesas de restaurantes.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar mesas de restaurantes,
 * utilizando los servicios de mesas de restaurantes y restaurantes
 * proporcionados por {@link TableRestaurantService} y
 * {@link RestaurantService}.
 * 
 * @author remr1
 */
@Component
public class TableRestaurantConsoleApp {
	private static TableRestaurantService tableRestaurantService;
	private static RestaurantService pRestaurantService;

	/**
	 * Método principal de la aplicación de consola de mesas de restaurantes que
	 * muestra un menú para interactuar con la gestión de mesas.
	 */
	public static void tableRestaurantConsoleAppMain() {
		tableRestaurantService = new TableRestaurantService();
		pRestaurantService = new RestaurantService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Mesas:");
			System.out.println("1. Crear mesa");
			System.out.println("2. Leer mesas");
			System.out.println("3. Actualizar mesa");
			System.out.println("4. Eliminar mesa");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createTable(scanner);
				break;
			case 2:
				readTables();
				break;
			case 3:
				updateTable(scanner);
				break;
			case 4:
				deleteTable(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea una nueva mesa de restaurante solicitando la información
	 * necesaria al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void createTable(Scanner scanner) {
		TableRestaurant table = new TableRestaurant();
		collectionData(table, scanner);
		tableRestaurantService.saveTableRestaurant(table);

		System.out.println("Mesa creada exitosamente!");
	}

	/**
	 * Método que muestra la lista de todas las mesas de restaurantes existentes.
	 */
	private static void readTables() {
		List<TableRestaurant> tables = tableRestaurantService.showAll();
		for (TableRestaurant table : tables) {
			System.out.println(table.toString());
		}
	}

	/**
	 * Método que actualiza la información de una mesa de restaurante existente
	 * solicitando la nueva información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateTable(Scanner scanner) {
		System.out.print("Ingrese el ID de la mesa a actualizar: ");
		int tableId = scanner.nextInt();
		TableRestaurant table = tableRestaurantService.FindById(tableId);
		collectionData(table, scanner);	
		
		tableRestaurantService.saveTableRestaurant(table);

		System.out.println("Mesa actualizada exitosamente!");
	}

	/**
	 * Método que elimina una mesa de restaurante existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteTable(Scanner scanner) {
		System.out.print("Ingrese el ID de la mesa a eliminar: ");
		int tableId = scanner.nextInt();
		TableRestaurant table = tableRestaurantService.FindById(tableId);
		tableRestaurantService.deleteTableRestaurant(table);

		System.out.println("Mesa eliminada exitosamente!");
	}

	private static void collectionData(TableRestaurant table, Scanner scanner) {
		System.out.print("Capacidad de la mesa: ");
		table.setCapacity(Validator.getAmount());
		table.setDescription(Validator.getDescription(scanner));
		table.toString();

		System.out.print("Descripción de la mesa: ");
		String description = scanner.next();

		System.out.print("Tema de la mesa: ");
		table.setTopic(Validator.getTopic(scanner));

		System.out.println(pRestaurantService.showAll());
		System.out.print("Ingrese el ID del restaurante: ");
		int restaurantId = Validator.getId(scanner);
		Restaurant restaurant = pRestaurantService.FindById(restaurantId);
		table.setRestaurant(restaurant);
		
		table.setStatus(Validator.getBooleanStatus(scanner, "Esta mesa esta habilitada?"));

	}
}