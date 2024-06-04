package com.parcialpoo.ufg.MR100823.Console;

//IngredientConsoleApp.java
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.Ingredient;
import com.parcialpoo.ufg.MR100823.services.IngredientService;

import java.util.List;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de ingredientes.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar ingredientes,
 * utilizando el servicio de ingredientes proporcionado por
 * {@link IngredientService}.
 * 
 * @author remr1
 */
@Component
public class IngredientsConsoleApp {
	private static IngredientService ingredientService;

	/**
	 * Método principal de la aplicación de consola de ingredientes que muestra un
	 * menú para interactuar con la gestión de ingredientes.
	 */
	public static void ingredientsConsoleAppmain() {
		ingredientService = new IngredientService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Ingredients:");
			System.out.println("1. Crear ingrediente");
			System.out.println("2. Leer ingredientes");
			System.out.println("3. Actualizar ingrediente");
			System.out.println("4. Eliminar ingrediente");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createIngredient(scanner);
				break;
			case 2:
				readIngredients();
				break;
			case 3:
				updateIngredient(scanner);
				break;
			case 4:
				deleteIngredient(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea un nuevo ingrediente solicitando la información necesaria al
	 * usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void createIngredient(Scanner scanner) {
		Ingredient ingredient = new Ingredient();
		colletionData(ingredient, scanner);
		ingredientService.saveIngredient(ingredient);

		System.out.println("Ingrediente creado exitosamente!");
	}

	/**
	 * Método que muestra la lista de todos los ingredientes existentes.
	 */
	private static void readIngredients() {
		List<Ingredient> ingredients = ingredientService.showAll();
		for (Ingredient ingredient : ingredients) {
			System.out.println(ingredient.toString());
		}
	}

	/**
	 * Método que actualiza la información de un ingrediente existente solicitando
	 * la nueva información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updateIngredient(Scanner scanner) {
		int id = Validator.getId(scanner);
		Ingredient ingredient = ingredientService.FindById(id);
		colletionData(ingredient, scanner);
		ingredientService.saveIngredient(ingredient);
		System.out.println("Ingrediente actualizado exitosamente!");
	}

	/**
	 * Método que elimina un ingrediente existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deleteIngredient(Scanner scanner) {
		System.out.print("Ingrese el ID del ingrediente a eliminar: ");
		int id = scanner.nextInt();

		Ingredient pIngredient = ingredientService.FindById(id);
		ingredientService.deleteIngredient(pIngredient);

		System.out.println("Ingrediente eliminado exitosamente!");
	}

	public static void colletionData(Ingredient pIngredient, Scanner scanner) {
		pIngredient.setName(Validator.getName());
		pIngredient.setDescription(Validator.getDescription(scanner));
		pIngredient.setAmount(Validator.getAmount());
		pIngredient.setPrice(Validator.getPrice(scanner));
	}
}