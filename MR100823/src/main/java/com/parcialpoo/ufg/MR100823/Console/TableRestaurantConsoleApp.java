package com.parcialpoo.ufg.MR100823.Console;

import java.util.List;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.models.TableRestaurant;
import com.parcialpoo.ufg.MR100823.services.RestaurantService;
import com.parcialpoo.ufg.MR100823.services.TableRestaurantService;
@Component
public class TableRestaurantConsoleApp {
	private static TableRestaurantService tableRestaurantService;
	private static RestaurantService pRestaurantService;

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

	private static void createTable(Scanner scanner) {
		System.out.print("Ingrese la capacidad de la mesa: ");
		int capacity = scanner.nextInt();

		System.out.print("Ingrese la descripción de la mesa: ");
		String description = scanner.next();

		System.out.print("Ingrese el tema de la mesa: ");
		String topic = scanner.next();

		System.out.println(pRestaurantService.showAll());
		System.out.print("Ingrese el ID del restaurante: ");
		int restaurantId = scanner.nextInt();
		Restaurant restaurant = pRestaurantService.FindById(restaurantId);

		TableRestaurant table = new TableRestaurant(capacity, description, topic, true, restaurant);
		tableRestaurantService.saveTableRestaurant(table);

		System.out.println("Mesa creada exitosamente!");
	}

	private static void readTables() {
		List<TableRestaurant> tables = tableRestaurantService.showAll();
		for (TableRestaurant table : tables) {
			System.out.println(table.toString());
		}
	}

	private static void updateTable(Scanner scanner) {
		System.out.print("Ingrese el ID de la mesa a actualizar: ");
		int tableId = scanner.nextInt();

		System.out.print("Ingrese la nueva capacidad de la mesa: ");
		int capacity = scanner.nextInt();

		System.out.print("Ingrese la nueva descripción de la mesa: ");
		String description = scanner.next();

		System.out.print("Ingrese el nuevo tema de la mesa: ");
		String topic = scanner.next();

		TableRestaurant table = tableRestaurantService.FindById(tableId);
		table.setCapacity(capacity);
		table.setDescription(description);
		table.setTopic(topic);
		tableRestaurantService.saveTableRestaurant(table);

		System.out.println("Mesa actualizada exitosamente!");
	}

	private static void deleteTable(Scanner scanner) {
		System.out.print("Ingrese el ID de la mesa a eliminar: ");
		int tableId = scanner.nextInt();
		TableRestaurant table = tableRestaurantService.FindById(tableId);
		tableRestaurantService.deleteTableRestaurant(table);

		System.out.println("Mesa eliminada exitosamente!");
	}
}