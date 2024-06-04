package com.parcialpoo.ufg.MR100823.Console;

import java.util.List;
//PaymentConsoleApp.java
import java.util.Scanner;

import org.springframework.stereotype.Component;

import java.sql.Time;

import com.parcialpoo.ufg.MR100823.models.OrderCostumer;
import com.parcialpoo.ufg.MR100823.models.Payment;
import com.parcialpoo.ufg.MR100823.models.Payment.Status;
import com.parcialpoo.ufg.MR100823.services.PaymentService;
import com.parcialpoo.ufg.MR100823.services.OrderCostumerService;

/**
 * Clase que proporciona una interfaz de consola para interactuar con la gestión
 * de pagos.
 * 
 * Esta clase permite crear, leer, actualizar y eliminar pagos, utilizando los
 * servicios de pagos y órdenes de clientes proporcionados por
 * {@link PaymentService} y {@link OrderCostumerService}.
 * 
 * @author remr1
 */
@Component
public class PaymentConsoleApp {
	private static PaymentService paymentService;
	private static OrderCostumerService orderCostumerService;

	/**
	 * Método principal de la aplicación de consola de pagos que muestra un menú
	 * para interactuar con la gestión de pagos.
	 */
	public static void paymentConsoleAppMain() {
		paymentService = new PaymentService();
		orderCostumerService = new OrderCostumerService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Pagos:");
			System.out.println("1. Leer pagos");
			System.out.println("2. Actualizar pago");
			System.out.println("3. Eliminar pago");
			System.out.println("4. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				readPayments();
				break;
			case 2:
				updatePayment(scanner);
				break;
			case 3:
				deletePayment(scanner);
				break;
			case 4:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	/**
	 * Método que crea un nuevo pago solicitando la información necesaria al
	 * usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	public static void createPayment(OrderCostumer orderCostumer, Scanner scanner) {

		Payment payment = new Payment();

		payment.setOrder(orderCostumer);
		int price = (int) orderCostumer.getTotalPrice();
		payment.setAmount(price);

		Time orderDate = new Time(System.currentTimeMillis());
		payment.setPaymentDate(orderDate);
		collectionData(payment, scanner);
		paymentService.savePayment(payment);

		System.out.println("Pago creado exitosamente!");
	}

	/**
	 * Método que muestra la lista de todos los pagos existentes.
	 */
	private static void readPayments() {
		List<Payment> payments = paymentService.showAll();
		for (Payment payment : payments) {
			System.out.println(payment.toString());
		}
	}

	/**
	 * Método que actualiza la información de un pago existente solicitando la nueva
	 * información al usuario.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void updatePayment(Scanner scanner) {
		System.out.print("Ingrese el ID del pago a actualizar: ");
		int paymentId = scanner.nextInt();
		Payment payment = paymentService.FindById(paymentId);
		collectionData(payment, scanner);
		paymentService.savePayment(payment);

		System.out.println("Pago actualizado exitosamente!");
	}

	/**
	 * Método que elimina un pago existente según su ID.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 */
	private static void deletePayment(Scanner scanner) {
		System.out.print("Ingrese el ID del pago a eliminar: ");
		int paymentId = scanner.nextInt();
		Payment payment = paymentService.FindById(paymentId);
		paymentService.deletePayment(payment);

		System.out.println("Pago eliminado exitosamente!");
	}

	private static void collectionData(Payment payment, Scanner scanner) {
		System.out.print("Ingrese el método de pago (TARJETA o EFECTIVO): ");
		String paymentMethod = scanner.next();
		payment.setPaymentMethod(getPaymentMethod(scanner));
		payment.setStatus(getStatus(scanner));
	}
	
	/**
	 * Valida el método de pago ingresado por el usuario y devuelve el enum correspondiente.
	 * 
	 * @param scanner el scanner para leer la entrada del usuario
	 * @return el enum Payment.Payment_method correspondiente al método de pago ingresado
	 */
	public static Payment.Payment_method getPaymentMethod(Scanner scanner) {
	    while (true) {
	        boolean isCard = Validator.getBooleanStatus(scanner, "¿Desea pagar con tarjeta?");
	        if (isCard) {
	            return Payment.Payment_method.TARJETA;
	        } else {
	            return Payment.Payment_method.EFECTIVO;
	        }
	    }
	}
	
	
	/**
	 * Valida el estado ingresado por el usuario y devuelve el enum correspondiente.
	 * 
	 * @param scanner el scanner para leer la entrada del usuario
	 * @return el enum Status correspondiente al estado ingresado
	 */
	public static Status getStatus(Scanner scanner) {
	    while (true) {
	        System.out.print("¿El estado es aprobado? (s/n): ");
	        boolean isApproved = getBooleanStatus(scanner, "");
	        if (isApproved) {
	            return Status.APPROVED;
	        } else {
	            System.out.print("¿El estado es rechazado? (s/n): ");
	            boolean isRejected = getBooleanStatus(scanner, "");
	            if (isRejected) {
	                return Status.REJECTED;
	            } else {
	                return Status.PENDING;
	            }
	        }
	    }
	}

	/**
	 * Convierte una respuesta del usuario en un booleano.
	 * 
	 * @param scanner el scanner para leer la entrada del usuario
	 * @param prompt  el mensaje a mostrar al usuario
	 * @return true si el usuario responde "s" o "S", false en caso contrario
	 */
	public static boolean getBooleanStatus(Scanner scanner, String prompt) {
	    while (true) {
	        String response = scanner.next().trim().toUpperCase();
	        if (response.equals("S")) {
	            return true;
	        } else if (response.equals("N")) {
	            return false;
	        } else {
	            System.out.print("Respuesta inválida. Intente nuevamente. " + prompt);
	        }
	    }
	}
	
}