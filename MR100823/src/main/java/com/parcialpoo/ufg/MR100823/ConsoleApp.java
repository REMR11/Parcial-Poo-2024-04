package com.parcialpoo.ufg.MR100823;

import java.util.Scanner;

import com.parcialpoo.ufg.MR100823.Console.*;

/**
 * Clase principal de la aplicación de consola que permite interactuar con
 * diferentes módulos de la aplicación.
 * 
 * Esta clase se encarga de mostrar un menú principal que permite al usuario
 * seleccionar una opción para interactuar con diferentes módulos de la
 * aplicación, como la gestión de clientes, platos, ingredientes, menús,
 * pedidos, pagos, reservas, restaurantes y mesas.
 * 
 * @author remr1
 */
public class ConsoleApp {
	private static CostumerConsoleApp pCostumerConsoleApp;
	private static FoodPlateConsoleApp pFoodPlateConsoleApp;
	private static IngredientsConsoleApp pIngredientsConsoleApp;
	private static MenuConsoleApp pMenuConsoleApp;
	private static OrderCostumerConsoleApp pOrderCostumerConsoleApp;
	private static PaymentConsoleApp pPaymentConsoleApp;
	private static ReservationConsoleApp pReservationConsoleApp;
	private static RestaurantConsoleApp pRestaurantConsoleApp;
	private static TableRestaurantConsoleApp pTableRestaurantConsoleApp;

	public static void main(String[] args) {
		primaryConsoleApp();
		showMenu();
	}

	/**
	 * Método principal de la aplicación que se encarga de inicializar los objetos
	 * de los módulos de la aplicación.
	 */
	private static void primaryConsoleApp() {
		pCostumerConsoleApp = new CostumerConsoleApp();
		pFoodPlateConsoleApp = new FoodPlateConsoleApp();
		pIngredientsConsoleApp = new IngredientsConsoleApp();
		pMenuConsoleApp = new MenuConsoleApp();
		pOrderCostumerConsoleApp = new OrderCostumerConsoleApp();
		pPaymentConsoleApp = new PaymentConsoleApp();
		pReservationConsoleApp = new ReservationConsoleApp();
		pRestaurantConsoleApp = new RestaurantConsoleApp();
		pTableRestaurantConsoleApp = new TableRestaurantConsoleApp();
	}

	/**
	 * Método que muestra el menú principal de la aplicación y permite al usuario
	 * seleccionar una opción para interactuar con diferentes módulos de la
	 * aplicación.
	 */
	private static void showMenu() {
		Scanner scanner = new Scanner(System.in);
		int option;

		while (true) {
			System.out.println("Seleccione una opción:");
			System.out.println("1. CostumerConsoleApp");
			System.out.println("2. FoodPlateConsoleApp");
			System.out.println("3. IngredientsConsoleApp");
			System.out.println("4. MenuConsoleApp");
			System.out.println("5. OrderCostumerConsoleApp");
			System.out.println("6. PaymentConsoleApp");
			System.out.println("7. ReservationConsoleApp");
			System.out.println("8. RestaurantConsoleApp");
			System.out.println("9. TableRestaurantConsoleApp");
			System.out.println("10. Salir");

			option = scanner.nextInt();

			switch (option) {
			case 1:
				pCostumerConsoleApp.costumerConsoleAppmain();
				break;
			case 2:
				pFoodPlateConsoleApp.foodPlateConsolemain();
				break;
			case 3:
				pIngredientsConsoleApp.ingredientsConsoleAppmain();
				break;
			case 4:
				pMenuConsoleApp.menuConsoleAppMain();
				break;
			case 5:
				pOrderCostumerConsoleApp.orderCostumerConsoleAppMain();
				break;
			case 6:
				pPaymentConsoleApp.paymentConsoleAppMain();
				break;
			case 7:
				pReservationConsoleApp.reservationConsoleAppMain();
				break;
			case 8:
				pRestaurantConsoleApp.restaurantConsoleAppMain();
				break;
			case 9:
				pTableRestaurantConsoleApp.tableRestaurantConsoleAppMain();
				break;
			case 10:
				System.out.println("Adiós!");
				return;
			default:
				System.out.println("Opción inválida. Intente nuevamente.");
			}
		}
	}
}