package com.parcialpoo.ufg.MR100823.Console;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.models.FoodPlate;
import com.parcialpoo.ufg.MR100823.models.OrderCostumer;
import com.parcialpoo.ufg.MR100823.models.OrderCostumer.Status;
import com.parcialpoo.ufg.MR100823.services.CostumerService;
import com.parcialpoo.ufg.MR100823.services.FoodPlateService;
import com.parcialpoo.ufg.MR100823.services.OrderCostumerService;

import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de órdenes de clientes.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar órdenes de clientes,
 * utilizando los servicios de órdenes, platos y clientes proporcionados por
 * {@link OrderCostumerService}, {@link FoodPlateService} y
 * {@link CostumerService}.
 * 
 * @author remr1
 */
@Component
public class OrderCostumerConsoleApp {
	private static OrderCostumerService orderCostumerService;
	private static FoodPlateService pPlateService;
	private static CostumerService pCostumerService;

	/**
	 * Método principal de la aplicación de consola de órdenes de clientes que
	 * muestra un menú para interactuar con la gestión de órdenes.
	 */
	public static void orderCostumerConsoleAppMain() {
		orderCostumerService = new OrderCostumerService();
		pPlateService = new FoodPlateService();
		pCostumerService = new CostumerService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Orders:");
			System.out.println("1. Crear orden");
			System.out.println("2. Leer órdenes");
			System.out.println("3. Actualizar orden");
			System.out.println("4. Eliminar orden");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createOrder(scanner);
				break;
			case 2:
				readOrders();
				break;
			case 3:
				updateOrder(scanner);
				break;
			case 4:
				deleteOrder(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método principal de la aplicación de consola de órdenes de clientes que
	 * muestra un menú para interactuar con la gestión de órdenes.
	 */
	private static void createOrder(Scanner scanner) {
		OrderCostumer order = new OrderCostumer();
		int costumerId = Validator.getId(scanner);
		Costumer pCostumer = pCostumerService.FindById(costumerId);

		order.setCostumer(pCostumer);
		PaymentConsoleApp.createPayment(order, scanner);
		orderCostumerService.saveOrderCostumer(order);

		System.out.println("Orden creada exitosamente!");
	}

	/**
	 * Método que muestra la lista de todas las órdenes de clientes existentes.
	 */
	private static void readOrders() {
		List<OrderCostumer> orders = orderCostumerService.showAll();
		for (OrderCostumer order : orders) {
			System.out.println(order.toString());
		}
	}

	/**
	 * Método que actualiza la información de una orden de cliente existente
	 * solicitando la nueva información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateOrder(Scanner scanner) {
		System.out.println(orderCostumerService.showAll());
		System.out.print("seleccione el ID de la orden a actualizar: ");
		int orderId = Validator.getId(scanner);

		OrderCostumer orderCostumer =   orderCostumerService.FindById(orderId);

		collectionData(orderCostumer, scanner);
	
		orderCostumerService.saveOrderCostumer(orderCostumer);

		System.out.println("Orden actualizada exitosamente!");
	}

	/**
	 * Método que elimina una orden de cliente existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteOrder(Scanner scanner) {
		System.out.print("Ingrese el ID de la orden a eliminar: ");
		int orderId = scanner.nextInt();
		OrderCostumer pOrderCostumer = orderCostumerService.FindById(orderId);
		orderCostumerService.deleteOrderCostumer(pOrderCostumer);

		System.out.println("Orden eliminada exitosamente!");
	}
	
	private static void collectionData(OrderCostumer orderCostumer, Scanner scanner) {
		
		System.out.println("Platos:");
		List<FoodPlate> plates = new ArrayList<FoodPlate>();

		float totalPrice = 0;
		System.out.println(pPlateService.showAll());
		while (true) {
			System.out.print("Ingrese el ID del plato (0 para terminar): ");
			int plateId = scanner.nextInt();
			if (plateId == 0) {
				break;
			}

			FoodPlate plate = pPlateService.FindById(plateId);
			totalPrice += plate.getPrice();
			plates.add(plate);
		}
		orderCostumer.setPlates(plates);
		orderCostumer.setTotalPrice(totalPrice);
		Time orderDate = new Time(System.currentTimeMillis());
		orderCostumer.setOrderDate(orderDate);
		orderCostumer.setQuantity(plates.size());
		orderCostumer.setStatus(getStatus(scanner));
		
	}
	
	/**
	 * Valida el estado ingresado por el usuario y devuelve el enum correspondiente.
	 * 
	 * @param scanner el scanner para leer la entrada del usuario
	 * @return el enum Status correspondiente al estado ingresado
	 */
	public static Status getStatus(Scanner scanner) {
	    while (true) {
	        System.out.print("¿Cuál es el estado de la orden? (0: PENDING, 1: PREPARING, 2: READY, 3: DELIVRED): ");
	        int statusCode = scanner.nextInt();
	        if (statusCode >= 0 && statusCode <= 3) {
	            return Status.values()[statusCode];
	        } else {
	            System.out.print("Código de estado inválido. Intente nuevamente: ");
	        }
	    }
	}
}