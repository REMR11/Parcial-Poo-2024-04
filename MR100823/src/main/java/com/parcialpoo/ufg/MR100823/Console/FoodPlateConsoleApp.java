package com.parcialpoo.ufg.MR100823.Console;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;
import com.parcialpoo.ufg.MR100823.models.Ingredient;
import com.parcialpoo.ufg.MR100823.services.FoodPlateService;
import com.parcialpoo.ufg.MR100823.services.IngredientService;

import lombok.val;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de platos de comida.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar platos de comida,
 * utilizando los servicios de platos de comida y ingredientes proporcionados
 * por {@link FoodPlateService} y {@link IngredientService}.
 * 
 * @author remr1
 */
@Component
public class FoodPlateConsoleApp {
	private static FoodPlateService foodPlateService;
	private static IngredientService pIngredientService;

	/**
	 * Método principal de la aplicación de consola de platos de comida que muestra
	 * un menú para interactuar con la gestión de platos de comida.
	 */
	public static void foodPlateConsolemain() {
		foodPlateService = new FoodPlateService();
		pIngredientService = new IngredientService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Food Plates:");
			System.out.println("1. Crear plato de comida");
			System.out.println("2. Leer platos de comida");
			System.out.println("3. Actualizar plato de comida");
			System.out.println("4. Eliminar plato de comida");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createFoodPlate(scanner);
				break;
			case 2:
				readFoodPlates();
				break;
			case 3:
				updateFoodPlate(scanner);
				break;
			case 4:
				deleteFoodPlate(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea un nuevo plato de comida solicitando la información necesaria
	 * al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void createFoodPlate(Scanner scanner) {
		
		FoodPlate foodPlate = new FoodPlate();
		collectionData(foodPlate, scanner);
		foodPlateService.saveFoodPlate(foodPlate);

		System.out.println("Plato de comida creado exitosamente!");
	}

	/**
	 * Método que muestra la lista de todos los platos de comida existentes.
	 */
	private static void readFoodPlates() {
		List<FoodPlate> foodPlates = foodPlateService.showAll();
		for (FoodPlate foodPlate : foodPlates) {
			System.out.println(foodPlate.toString());
		}
	}

	/**
	 * Método que actualiza la información de un plato de comida existente
	 * solicitando la nueva información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateFoodPlate(Scanner scanner) {
		int id = Validator.getId(scanner);
		
		System.out.println(pIngredientService.FindById(id).toString() + "\n");

		System.out.print("Ingrese el nuevo nombre del plato de comida: ");
		String name = scanner.next();

		System.out.print("Ingrese la nueva descripción del plato de comida: ");
		String description = scanner.next();

		System.out.print("Ingrese el nuevo precio del plato de comida: ");
		float price = scanner.nextFloat();

		System.out.print("Ingrese la nueva disponibilidad del plato de comida (true/false): ");
		boolean availability = scanner.nextBoolean();

		System.out.println("Ingredientes:");
		List<Ingredient> ingredients = new ArrayList<>();
		Ingredient pingredients = new Ingredient();
		System.out.println(pingredients.toString());
		while (true) {
			System.out.print("Ingrese el ID del ingrediente (0 para terminar): ");
			int Ingredientid = scanner.nextInt();
			if (Ingredientid == 0) {
				break;
			}

			Ingredient ingredient = pIngredientService.FindById(Ingredientid);
			ingredients.add(ingredient);
		}

		FoodPlate foodPlate = new FoodPlate(id, name, description, price, availability, ingredients);
		foodPlateService.saveFoodPlate(foodPlate);

		System.out.println("Plato de comida actualizado exitosamente!");
	}

	/**
	 * Método que elimina un plato de comida existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteFoodPlate(Scanner scanner) {
		int id = Validator.getId(scanner);
		FoodPlate pFoodPlate = foodPlateService.FindById(id);
		foodPlateService.deleteFoodPlate(pFoodPlate);

		System.out.println("Plato de comida eliminado exitosamente!");
	}
	
	private static void collectionData(FoodPlate foodPlate, Scanner scanner) {
		foodPlate.setName(Validator.getName());
		foodPlate.setDescription(Validator.getDescription(scanner));
		float price =0;
		
		System.out.println("Ingredientes:");
		List<Ingredient> ingredients = new ArrayList<>();
		System.out.println(pIngredientService.showAll());
		while (true) {
			System.out.print("Ingrese el ID del ingrediente (0 para terminar): ");
			int id = scanner.nextInt();
			if (id == 0) {
				break;
			}

			Ingredient ingredient = pIngredientService.FindById(id);
			price+= ingredient.getPrice();
			ingredients.add(ingredient);
		}
		
		foodPlate.setAvailability(true);

	}
}