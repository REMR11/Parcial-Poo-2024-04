package com.parcialpoo.ufg.MR100823.Console;

import java.util.Scanner;
import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Restaurant;
import com.parcialpoo.ufg.MR100823.services.RestaurantService;

public class RestaurantConsoleApp {
    private static RestaurantService restaurantService;

    public static void main(String[] args) {
        restaurantService = new RestaurantService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Restaurantes:");
            System.out.println("1. Crear restaurante");
            System.out.println("2. Leer restaurantes");
            System.out.println("3. Actualizar restaurante");
            System.out.println("4. Eliminar restaurante");
            System.out.println("5. Volver");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createRestaurant(scanner);
                    break;
                case 2:
                    readRestaurants();
                    break;
                case 3:
                    updateRestaurant(scanner);
                    break;
                case 4:
                    deleteRestaurant(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void createRestaurant(Scanner scanner) {
        System.out.print("Ingrese la dirección del restaurante: ");
        String address = scanner.next();

        System.out.print("Ingrese el nombre del restaurante: ");
        String name = scanner.next();

        System.out.print("Ingrese el número de teléfono del restaurante: ");
        int phoneNumber = scanner.nextInt();

        Restaurant restaurant = new Restaurant(0, address, name, phoneNumber, null, null, null);
        restaurantService.saveRestaurant(restaurant);

        System.out.println("Restaurante creado exitosamente!");
    }

    private static void readRestaurants() {
        List<Restaurant> restaurants = restaurantService.showAll();
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.toString());
        }
    }

    private static void updateRestaurant(Scanner scanner) {
        System.out.print("Ingrese el ID del restaurante a actualizar: ");
        int restaurantId = scanner.nextInt();
        Restaurant restaurant = restaurantService.FindById(restaurantId);

        System.out.print("Ingrese la nueva dirección del restaurante: ");
        String address = scanner.next();
        restaurant.setAddress(address);

        System.out.print("Ingrese el nuevo nombre del restaurante: ");
        String name = scanner.next();
        restaurant.setName(name);

        System.out.print("Ingrese el nuevo número de teléfono del restaurante: ");
        int phoneNumber = scanner.nextInt();
        restaurant.setPhoneNumber(phoneNumber);

        restaurantService.saveRestaurant(restaurant);

        System.out.println("Restaurante actualizado exitosamente!");
    }

    private static void deleteRestaurant(Scanner scanner) {
        System.out.print("Ingrese el ID del restaurante a eliminar: ");
        int restaurantId = scanner.nextInt();
        Restaurant restaurant = restaurantService.FindById(restaurantId);
        restaurantService.deleteRestaurant(restaurant);

        System.out.println("Restaurante eliminado exitosamente!");
    }
}