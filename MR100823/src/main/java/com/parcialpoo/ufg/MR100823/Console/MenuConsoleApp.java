package com.parcialpoo.ufg.MR100823.Console;

//MenuConsoleApp.java
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;
import com.parcialpoo.ufg.MR100823.models.Menu;
import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.models.TableRestaurant;
import com.parcialpoo.ufg.MR100823.services.FoodPlateService;
import com.parcialpoo.ufg.MR100823.services.MenuService;
import com.parcialpoo.ufg.MR100823.services.RestaurantService;
import com.parcialpoo.ufg.MR100823.services.TableRestaurantService;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de menús.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar menús, utilizando los
 * servicios de menús y restaurantes proporcionados por {@link MenuService} y
 * {@link RestaurantService}.
 * 
 * @author remr1
 */
@Component
public class MenuConsoleApp {
	private static MenuService menuService;
	private static RestaurantService restaurantService;
	private static FoodPlateService pFoodPlateService;
	private static TableRestaurantService tableRestaurantService;

	/**
	 * Método principal de la aplicación de consola de menús que muestra un menú
	 * para interactuar con la gestión de menús.
	 */
	public static void menuConsoleAppMain() {
		menuService = new MenuService();
		restaurantService = new RestaurantService();
		pFoodPlateService =new FoodPlateService();
		tableRestaurantService = new TableRestaurantService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menús:");
			System.out.println("1. Crear menú");
			System.out.println("2. Leer menús");
			System.out.println("3. Actualizar menú");
			System.out.println("4. Eliminar menú");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createMenu(scanner);
				break;
			case 2:
				readMenus();
				break;
			case 3:
				updateMenu(scanner);
				break;
			case 4:
				deleteMenu(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea un nuevo menú solicitando la información necesaria al
	 * usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void createMenu(Scanner scanner) {
		Menu menu = new Menu();
		collectionData(menu, scanner);
		menuService.saveMenu(menu);

		System.out.println("Menú creado exitosamente!");
	}

	/**
	 * Método que muestra la lista de todos los menús existentes.
	 */
	public static void readMenus() {
		List<Menu> menus = menuService.showAll();
		for (Menu menu : menus) {
			System.out.println(menu.toString());
		}
	}

	/**
	 * Método que actualiza la información de un menú existente solicitando la nueva
	 * información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateMenu(Scanner scanner) {
		int menuId = Validator.getId(scanner);
		Menu menu = menuService.FindById(menuId);
		collectionData(menu, scanner);
		menuService.saveMenu(menu);

		System.out.println("Menú actualizado exitosamente!");
	}

	/**
	 * Método que elimina un menú existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteMenu(Scanner scanner) {
		System.out.print("Ingrese el ID del menú a eliminar: ");
		int menuId = scanner.nextInt();
		Menu menu = menuService.FindById(menuId);
		menuService.deleteMenu(menu);

		System.out.println("Menú eliminado exitosamente!");
	}
	
	private static void collectionData(Menu menu, Scanner scanner) {
		menu.setName(Validator.getName(scanner));
		menu.setDescription(Validator.getDescription(scanner));
		System.out.println(restaurantService.showAll());
		int restaurantId = Validator.getId(scanner);
		Restaurant pRestaurant = restaurantService.FindById(restaurantId);
		menu.setRestaurant(pRestaurant);
		
		System.out.println("Platillos:");
		List<FoodPlate> foodPlates = new ArrayList<>();
		System.out.println(pFoodPlateService.showAll());
		int price = 0;
		while (true) {
			System.out.print("selecciona el ID del platillo (0 para terminar): ");
			int id = Validator.getId(scanner);
			if (id == 0) {
				break;
			}

			FoodPlate pFoodPlate = pFoodPlateService.FindById(id);
			price += pFoodPlate.getPrice();
			foodPlates.add(pFoodPlate);
		}
		menu.setPrice(price);

		System.out.println("Mesas:");
		List<TableRestaurant> mesas = new ArrayList<>();
		System.out.println(tableRestaurantService.showAll());

		while (true) {
			System.out.print("Seleccione el ID de la mesa (0 para terminar): ");
			int id = Validator.getId(scanner);
			if (id == 0) {
				break;
			}

			FoodPlate pFoodPlate = pFoodPlateService.FindById(id);
			foodPlates.add(pFoodPlate);
		}
	}
}