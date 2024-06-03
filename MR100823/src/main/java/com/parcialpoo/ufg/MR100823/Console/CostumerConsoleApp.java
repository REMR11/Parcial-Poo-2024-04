package com.parcialpoo.ufg.MR100823.Console;
import java.util.Scanner;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.services.CostumerService;

import java.util.List;

public class CostumerConsoleApp {
    private static CostumerService costumerService;

    public static void main(String[] args) {
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

    private static void createCostumer(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String name = scanner.next();

        System.out.print("Ingrese el correo electrónico: ");
        String email = scanner.next();

        System.out.print("Ingrese la contraseña: ");
        String password = scanner.next();
        

        System.out.print("Ingrese numero telefonico: ");
        String number = scanner.next();
        int phoneNumber = Integer.parseInt(number);
        
        Costumer costumer = new Costumer(name, email, password, phoneNumber);
        costumerService.saveCostumer(costumer);

        System.out.println("Costumer creado exitosamente!");
    }

    private static void readCostumers() {
        List<Costumer> costumers = costumerService.showAll();
        for (Costumer costumer : costumers) {
            System.out.println(costumer.toString());
        }
    }

    private static void updateCostumer(Scanner scanner) {

        System.out.print("Ingrese el nuevo nombre del costumer: ");
        String name = scanner.next();

        System.out.print("Ingrese el nuevo correo electrónico del costumer: ");
        String email = scanner.next();

        System.out.print("Ingrese la nueva contraseña del costumer: ");
        String password = scanner.next();

        System.out.print("Ingrese el nuevo numero telefonico: ");
        String number = scanner.next();
        int phoneNumber = Integer.parseInt(number);

        Costumer costumer = new Costumer(name, email, password, phoneNumber);
        costumerService.saveCostumer(costumer);

        System.out.println("Costumer actualizado exitosamente!");
    }

    private static void deleteCostumer(Scanner scanner) {
        System.out.print("Ingrese el ID del costumer a eliminar: ");
        int id = scanner.nextInt();
        Costumer pCostumer = costumerService.FindById(id);
        costumerService.deleteCostumer(pCostumer);

        System.out.println("Costumer eliminado exitosamente!");
    }
}