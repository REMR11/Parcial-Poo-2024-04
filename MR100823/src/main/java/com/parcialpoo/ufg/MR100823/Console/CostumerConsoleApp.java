package com.parcialpoo.ufg.MR100823.Console;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.services.CostumerService;

import java.util.List;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de clientes.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar clientes, utilizando el
 * servicio de clientes proporcionado por {@link CostumerService}.
 * 
 * @author remr1
 */
@Component
public class CostumerConsoleApp {
	private static CostumerService costumerService;

	/**
	 * Método principal de la aplicación de consola de clientes que muestra un menú
	 * para interactuar con la gestión de clientes.
	 */
	public static void costumerConsoleAppmain() {
		costumerService = new CostumerService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Costumers:");
			System.out.println("1. Crear costumer");
			System.out.println("2. Leer costumers");
			System.out.println("3. Actualizar costumer");
			System.out.println("4. Eliminar costumer");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createCostumer(scanner);
				break;
			case 2:
				readCostumers();
				break;
			case 3:
				updateCostumer(scanner);
				break;
			case 4:
				deleteCostumer(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea un nuevo cliente solicitando la información necesaria al
	 * usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void createCostumer(Scanner scanner) {
		Costumer costumer = new Costumer();
		collectionData(costumer, scanner);
		costumerService.saveCostumer(costumer);

		System.out.println("Costumer creado exitosamente!");
	}

	/**
	 * Método que muestra la lista de todos los clientes existentes.
	 */
	private static void readCostumers() {
		List<Costumer> costumers = costumerService.showAll();
		for (Costumer costumer : costumers) {
			System.out.println(costumer.toString());
		}
	}

	/**
	 * Método que actualiza la información de un cliente existente solicitando la
	 * nueva información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateCostumer(Scanner scanner) {
		int id = Validator.getId(scanner);
		Costumer costumer = costumerService.FindById(id);
		collectionData(costumer, scanner);
		costumerService.saveCostumer(costumer);

		System.out.println("Costumer actualizado exitosamente!");
	}

	/**
	 * Método que elimina un cliente existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteCostumer(Scanner scanner) {
		int id = Validator.getId(scanner);
		Costumer pCostumer = costumerService.FindById(id);
		costumerService.deleteCostumer(pCostumer);

		System.out.println("Costumer eliminado exitosamente!");
	}

	private static void collectionData(Costumer pCostumer, Scanner scanner) {
		System.out.print("Name: ");
		String name = scanner.nextLine();
		pCostumer.setName(name);
		pCostumer.setEmail(Validator.getEmail());
		pCostumer.setPhone(Validator.getPhoneNumber());
		pCostumer.setPassword(Validator.getPassword());
	}
}