package com.parcialpoo.ufg.MR100823.Console;

import java.util.List;
//PaymentConsoleApp.java
import java.util.Scanner;

import org.springframework.stereotype.Component;

import java.sql.Time;

import com.parcialpoo.ufg.MR100823.models.OrderCostumer;
import com.parcialpoo.ufg.MR100823.models.Payment;
import com.parcialpoo.ufg.MR100823.services.PaymentService;
import com.parcialpoo.ufg.MR100823.services.OrderCostumerService;

@Component
public class PaymentConsoleApp {
	private static PaymentService paymentService;
	private static OrderCostumerService orderCostumerService;

	public static void paymentConsoleAppMain() {
		paymentService = new PaymentService();
		orderCostumerService = new OrderCostumerService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Pagos:");
			System.out.println("1. Crear pago");
			System.out.println("2. Leer pagos");
			System.out.println("3. Actualizar pago");
			System.out.println("4. Eliminar pago");
			System.out.println("5. Volver");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				createPayment(scanner);
				break;
			case 2:
				readPayments();
				break;
			case 3:
				updatePayment(scanner);
				break;
			case 4:
				deletePayment(scanner);
				break;
			case 5:
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	private static void createPayment(Scanner scanner) {
		System.out.print("Ingrese el ID del pedido: ");
		int orderId = scanner.nextInt();
		OrderCostumer order = orderCostumerService.FindById(orderId);

		System.out.print("Ingrese el método de pago (TARJETA o EFECTIVO): ");
		String paymentMethod = scanner.next();
		Payment.Payment_method paymentMethodEnum = paymentMethod.equals("TARJETA") ? Payment.Payment_method.TARJETA
				: Payment.Payment_method.EFECTIVO;

		System.out.print("Ingrese la fecha de pago (HH:mm:ss): ");
		String paymentDateStr = scanner.next();
		Time paymentDate = Time.valueOf(paymentDateStr);

		System.out.print("Ingrese el monto del pago: ");
		int amount = scanner.nextInt();

		Payment.Status statusEnum = Payment.Status.PENDING;

		Payment payment = new Payment(order, paymentMethodEnum, paymentDate, amount, statusEnum);
		paymentService.savePayment(payment);

		System.out.println("Pago creado exitosamente!");
	}

	private static void readPayments() {
		List<Payment> payments = paymentService.showAll();
		for (Payment payment : payments) {
			System.out.println(payment.toString());
		}
	}

	private static void updatePayment(Scanner scanner) {
		System.out.print("Ingrese el ID del pago a actualizar: ");
		int paymentId = scanner.nextInt();
		Payment payment = paymentService.FindById(paymentId);
		System.out.println(payment.toString());

		System.out.print("Ingrese el nuevo método de pago (TARJETA o EFECTIVO): ");
		String paymentMethod = scanner.next();
		payment.setPaymentMethod(
				paymentMethod.equals("TARJETA") ? Payment.Payment_method.TARJETA : Payment.Payment_method.EFECTIVO);

		System.out.print("Ingrese la nueva fecha de pago (HH:mm:ss): ");
		String paymentDateStr = scanner.next();
		payment.setPaymentDate(Time.valueOf(paymentDateStr));

		System.out.print("Ingrese el nuevo monto del pago: ");
		int amount = scanner.nextInt();
		payment.setAmount(amount);

		System.out.print("Ingrese el nuevo estado del pago (PENDING, APPROVED o REJECTED): ");
		String statusStr = scanner.next();
		payment.setStatus(statusStr.equals("PENDING") ? Payment.Status.PENDING
				: statusStr.equals("APPROVED") ? Payment.Status.APPROVED : Payment.Status.REJECTED);

		paymentService.savePayment(payment);

		System.out.println("Pago actualizado exitosamente!");
	}

	private static void deletePayment(Scanner scanner) {
		System.out.print("Ingrese el ID del pago a eliminar: ");
		int paymentId = scanner.nextInt();
		Payment payment = paymentService.FindById(paymentId);
		paymentService.deletePayment(payment);

		System.out.println("Pago eliminado exitosamente!");
	}
}