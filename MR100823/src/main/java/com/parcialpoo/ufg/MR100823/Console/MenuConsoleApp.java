package com.parcialpoo.ufg.MR100823.Console;
//MenuConsoleApp.java
import java.util.Scanner;

import com.parcialpoo.ufg.MR100823.models.Menu;
import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.services.MenuService;
import com.parcialpoo.ufg.MR100823.services.RestaurantService;

import java.util.List;

public class MenuConsoleApp {
 private static MenuService menuService;
 private static RestaurantService restaurantService;

 public static void menuConsoleAppMain() {
     menuService = new MenuService();
     restaurantService = new RestaurantService();

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

 private static void createMenu(Scanner scanner) {
     System.out.print("Ingrese el nombre del menú: ");
     String name = scanner.next();

     System.out.print("Ingrese la descripción del menú: ");
     String description = scanner.next();

     System.out.print("Ingrese el precio del menú: ");
     int price = scanner.nextInt();

     System.out.println(restaurantService.showAll());
     System.out.print("Ingrese el ID del restaurante: ");
     int restaurantId = scanner.nextInt();
     Restaurant restaurant = restaurantService.FindById(restaurantId);

     Menu menu = new Menu(name, description, price, restaurant);
     menuService.saveMenu(menu);

     System.out.println("Menú creado exitosamente!");
 }

 public static void readMenus() {
     List<Menu> menus = menuService.showAll();
     for (Menu menu : menus) {
         System.out.println(menu.toString());
     }
 }

 private static void updateMenu(Scanner scanner) {
     System.out.print("Ingrese el ID del menú a actualizar: ");
     int menuId = scanner.nextInt();

     System.out.print("Ingrese el nuevo nombre del menú: ");
     String name = scanner.next();

     System.out.print("Ingrese la nueva descripción del menú: ");
     String description = scanner.next();

     System.out.print("Ingrese el nuevo precio del menú: ");
     int price = scanner.nextInt();

     Menu menu = menuService.FindById(menuId);
     menu.setName(name);
     menu.setDescription(description);
     menu.setPrice(price);
     menuService.saveMenu(menu);

     System.out.println("Menú actualizado exitosamente!");
 }

 private static void deleteMenu(Scanner scanner) {
     System.out.print("Ingrese el ID del menú a eliminar: ");
     int menuId = scanner.nextInt();
     Menu menu = menuService.FindById(menuId);
     menuService.deleteMenu(menu);

     System.out.println("Menú eliminado exitosamente!");
 }
}