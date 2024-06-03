package com.parcialpoo.ufg.MR100823.Console;

import java.util.Scanner;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.models.FoodPlate;
import com.parcialpoo.ufg.MR100823.models.OrderCostumer;
import com.parcialpoo.ufg.MR100823.services.CostumerService;
import com.parcialpoo.ufg.MR100823.services.FoodPlateService;
import com.parcialpoo.ufg.MR100823.services.OrderCostumerService;

import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

public class OrderCostumerConsoleApp {
	private static OrderCostumerService orderCostumerService;
	private static FoodPlateService pPlateService;
	private static CostumerService  pCostumerService;
	public static void main(String[] args) {
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

	private static void createOrder(Scanner scanner) {
		System.out.print("Ingrese el ID del cliente: ");
		int costumerId = scanner.nextInt();
		Costumer pCostumer = pCostumerService.FindById(costumerId);
		
		System.out.println("Platos:");
		List<FoodPlate> plates = new ArrayList<FoodPlate>();
		FoodPlateService pfoFoodPlate = new FoodPlateService();
		System.out.println(pfoFoodPlate.showAll());
		while (true) {
			System.out.print("Ingrese el ID del plato (0 para terminar): ");
			int plateId = scanner.nextInt();
			if (plateId == 0) {
				break;
			}

			FoodPlate plate = pPlateService.FindById(plateId);
			plates.add(plate);
		}

		Time orderDate = new Time(System.currentTimeMillis());

		int quantity = plates.size();

		float totalPrice = 0;
		for (FoodPlate plate : plates) {
			totalPrice += plate.getPrice();
		}

		OrderCostumer order = new OrderCostumer(pCostumer, plates, orderDate, quantity,totalPrice,
				OrderCostumer.Status.PENDING);
		orderCostumerService.saveOrderCostumer(order);

		System.out.println("Orden creada exitosamente!");
	}

	private static void readOrders() {
		List<OrderCostumer> orders = orderCostumerService.showAll();
		for (OrderCostumer order : orders) {
			System.out.println(order.toString());
		}
	}

	private static void updateOrder(Scanner scanner) {
		System.out.print("Ingrese el ID de la orden a actualizar: ");
		int orderId = scanner.nextInt();
		
		System.out.println(orderCostumerService.FindById(orderId));
		
		System.out.print("Ingrese el nuevo estado de la orden (PENDING, PREPARING, READY, DELIVRED): ");
		String status = scanner.next();

		OrderCostumer order = orderCostumerService.FindById(orderId);
		order.setStatus(OrderCostumer.Status.valueOf(status));
		orderCostumerService.saveOrderCostumer(order);

		System.out.println("Orden actualizada exitosamente!");
	}

	private static void deleteOrder(Scanner scanner) {
		System.out.print("Ingrese el ID de la orden a eliminar: ");
		int orderId = scanner.nextInt();
		OrderCostumer pOrderCostumer = orderCostumerService.FindById(orderId);
		orderCostumerService.deleteOrderCostumer(pOrderCostumer);

		System.out.println("Orden eliminada exitosamente!");
	}
}