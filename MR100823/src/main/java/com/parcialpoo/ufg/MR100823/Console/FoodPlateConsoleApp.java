package com.parcialpoo.ufg.MR100823.Console;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;
import com.parcialpoo.ufg.MR100823.models.Ingredient;
import com.parcialpoo.ufg.MR100823.services.FoodPlateService;
import com.parcialpoo.ufg.MR100823.services.IngredientService;

import java.util.List;
import java.util.ArrayList;
@Component
public class FoodPlateConsoleApp {
	private static FoodPlateService foodPlateService;
	private static IngredientService pIngredientService;

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

	private static void createFoodPlate(Scanner scanner) {
     System.out.print("Ingrese el nombre del plato de comida: ");
     String name = scanner.next();

     System.out.print("Ingrese la descripción del plato de comida: ");
     String description = scanner.next();

     System.out.print("Ingrese el precio del plato de comida: ");
     float price = scanner.nextFloat();

     System.out.println("Ingredientes:");
     List<Ingredient> ingredients = new ArrayList<>();
     Ingredient pingredients = new Ingredient();
     System.out.println(pingredients.toString());
     while (true) {
         System.out.print("Ingrese el ID del ingrediente (0 para terminar): ");
         int id = scanner.nextInt();
         if (id == 0) {
             break;
         }
         
         Ingredient ingredient = pIngredientService.FindById(id);
         ingredients.add(ingredient);
     }

     FoodPlate foodPlate = new FoodPlate(name, description, price, true, ingredients);
     foodPlateService.saveFoodPlate(foodPlate);

     System.out.println("Plato de comida creado exitosamente!");
 }

	private static void readFoodPlates() {
		List<FoodPlate> foodPlates = foodPlateService.showAll();
		for (FoodPlate foodPlate : foodPlates) {
			System.out.println(foodPlate.toString());
		}
	}

	private static void updateFoodPlate(Scanner scanner) {
		System.out.print("Ingrese el ID del plato de comida a actualizar: ");
		int id = scanner.nextInt();
		
		System.out.println(pIngredientService.FindById(id).toString()+"\n");

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

	private static void deleteFoodPlate(Scanner scanner) {
		System.out.print("Ingrese el ID del plato de comida a eliminar: ");
		int id = scanner.nextInt();
		FoodPlate pFoodPlate = foodPlateService.FindById(id);
		foodPlateService.deleteFoodPlate(pFoodPlate);

		System.out.println("Plato de comida eliminado exitosamente!");
	}
}