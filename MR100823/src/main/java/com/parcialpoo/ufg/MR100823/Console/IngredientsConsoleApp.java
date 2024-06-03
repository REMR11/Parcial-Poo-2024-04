package com.parcialpoo.ufg.MR100823.Console;
//IngredientConsoleApp.java
import java.util.Scanner;

import com.parcialpoo.ufg.MR100823.models.Ingredient;
import com.parcialpoo.ufg.MR100823.services.IngredientService;

import java.util.List;

public class IngredientsConsoleApp {
 private static IngredientService ingredientService;

 public static void main(String[] args) {
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

 private static void createIngredient(Scanner scanner) {
     System.out.print("Ingrese el nombre del ingrediente: ");
     String name = scanner.next();

     System.out.print("Ingrese la cantidad del ingrediente: ");
     String description = scanner.next();

     System.out.print("Ingrese la unidad del ingrediente: ");
     int unit = scanner.nextInt();
     
     System.out.print("Ingrese precio de la unidad del ingrediente: ");
     float price = scanner.nextFloat();
     Ingredient ingredient = new Ingredient(name, description, price, unit);
     ingredientService.saveIngredient(ingredient);

     System.out.println("Ingrediente creado exitosamente!");
 }

 private static void readIngredients() {
     List<Ingredient> ingredients = ingredientService.showAll();
     for (Ingredient ingredient : ingredients) {
         System.out.println(ingredient.toString());
     }
 }

 private static void updateIngredient(Scanner scanner) {
	 System.out.print("Ingrese el nuevo nombre del ingrediente: ");
     String name = scanner.next();

     System.out.print("Ingrese la nuevo cantidad del ingrediente: ");
     String description = scanner.next();

     System.out.print("Ingrese la nueva unidad del ingrediente: ");
     int unit = scanner.nextInt();
     
     System.out.print("Ingrese el nuevo precio de la unidad del ingrediente: ");
     float price = scanner.nextFloat();
     Ingredient ingredient = new Ingredient(name, description, price, unit);
     ingredientService.saveIngredient(ingredient);
     System.out.println("Ingrediente actualizado exitosamente!");
 }

 private static void deleteIngredient(Scanner scanner) {
     System.out.print("Ingrese el ID del ingrediente a eliminar: ");
     int id = scanner.nextInt();

     Ingredient pIngredient= ingredientService.FindById(id);
     ingredientService.deleteIngredient(pIngredient);

     System.out.println("Ingrediente eliminado exitosamente!");
 }
}