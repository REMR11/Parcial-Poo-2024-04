package com.parcialpoo.ufg.MR100823.Console;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Clase que proporciona métodos para validar diferentes tipos de datos.
 */
public class Validator {
	
	/**
	 * Pide al usuario que ingrese un status booleano (si/no) y devuelve el valor booleano correspondiente.
	 * 
	 * @param scanner el scanner para leer la entrada del usuario
	 * @param message el mensaje que se muestra al usuario para pedir la entrada
	 * @return true si el usuario ingresa "s" o "S", false si ingresa "n" o "N"
	 */
	public static boolean getBooleanStatus(Scanner scanner, String message) {
	    while (true) {
	        try {
	            System.out.print(message + " (s/n): ");
	            String input = scanner.next();
	            if (input.equalsIgnoreCase("s")) {
	                return true;
	            } else if (input.equalsIgnoreCase("n")) {
	                return false;
	            } else {
	                System.out.println("Opción inválida. Intente nuevamente.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Error: entrada no válida. Intente nuevamente.");
	            scanner.next(); // descartar la entrada inválida
	        }
	    }
	}
	/**
	 * Verifica si una dirección es válida.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 * @return la dirección válida
	 */
	public static String getAddress(Scanner scanner) {
		System.out.print("Ingrese la dirección: ");
		String address = scanner.nextLine();
		// Lógica para validar la dirección
		// Por ejemplo, verificando que no esté vacía y tenga un mínimo de caracteres
		if (address != null && !address.trim().isEmpty() && address.length() >= 5) {
			return address;
		} else {
			System.out.println("Dirección inválida. Intente nuevamente.");
			return getAddress(scanner);
		}
	}

	/**
	 * Verifica si una tema es válida.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 * @return tema de la mesa
	 */
	public static String getTopic(Scanner scanner) {
		System.out.print("Ingrese la tematica de la mesa: ");
		String topic = scanner.nextLine();
		// Lógica para validar la dirección
		// Por ejemplo, verificando que no esté vacía y tenga un mínimo de caracteres
		if (topic != null && !topic.trim().isEmpty() && topic.length() >= 5) {
			return topic;
		} else {
			System.out.println("Tema invalido. Intente nuevamente.");
			return getTopic(scanner);
		}
	}

	/**
	 * Verifica si un correo electrónico es válido.
	 * 
	 * @param email el correo electrónico a validar
	 * @return true si el correo electrónico es válido, false en caso contrario
	 */
	public static String getEmail() {
		String email;
		while (true) {
			try {
				System.out.print("Ingrese un correo electrónico: ");
				email = System.console().readLine();
				// Lógica para validar el correo electrónico
				// Por ejemplo, utilizando una expresión regular
				String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
				if (email.matches(emailRegex)) {
					return email;
				} else {
					System.out.println("Correo electrónico inválido. Intente nuevamente.");
				}
			} catch (PatternSyntaxException e) {
				// Manejar excepción en caso de que la expresión regular sea inválida
				System.err.println("Error en la expresión regular: " + e.getMessage());
			}
		}
	}

	/**
	 * Verifica si un nombre es válido.
	 * 
	 * @return un nombre válido
	 */
	public static String getName() {
		String name;
		while (true) {
			try {
				System.out.print("Ingrese un nombre: ");
				name = System.console().readLine();
				// Lógica para validar el nombre
				// Por ejemplo, verificando que no esté vacío y tenga al menos 2 caracteres
				if (!name.isEmpty() && name.trim().length() >= 2) {
					return name;
				} else {
					System.out.println("Nombre inválido. Intente nuevamente.");
				}
			} catch (NullPointerException e) {
				// Manejar excepción en caso de que el nombre sea nulo
				System.err.println("El nombre no puede ser nulo");
			}
		}
	}

	/**
	 * Verifica si una contraseña es válida.
	 * 
	 * @return una contraseña válida
	 */
	public static String getPassword() {
		String password;
		while (true) {
			try {
				System.out.print("Ingrese una contraseña: ");
				password = System.console().readLine();
				// Lógica para validar la contraseña
				// Por ejemplo, verificando que tenga al menos 8 caracteres y contenga al menos
				// una letra mayúscula y un número
				if (password.length() >= 8 && password.matches("^(?=.*[A-Z])(?=.*[0-9]).*$")) {
					return password;
				} else {
					System.out.println("Contraseña inválida. Intente nuevamente.");
				}
			} catch (PatternSyntaxException e) {
				// Manejar excepción en caso de que la expresión regular sea inválida
				System.err.println("Error en la expresión regular: " + e.getMessage());
			}
		}
	}

	/**
	 * Verifica si un número de teléfono es válido.
	 * 
	 * @return un número de teléfono válido
	 */
	public static Integer getPhoneNumber() {
		String phoneNumber;
		while (true) {
			try {
				System.out.print("Ingrese un número de teléfono: ");
				phoneNumber = System.console().readLine();
				// Lógica para validar el número de teléfono
				// Por ejemplo, verificando que sea un número positivo y tenga al menos 7
				// dígitos
				int number = Integer.parseInt(phoneNumber);
				if (number > 0 && number >= 7) {
					return number;
				} else {
					System.out.println("Número de teléfono inválido. Intente nuevamente.");
				}
			} catch (NumberFormatException e) {
				// Manejar excepción en caso de que el número de teléfono no sea un número
				// válido
				System.err.println("El número de teléfono debe ser un número válido");
			}
		}
	}

	/**
	 * Solicita la descripción del objeto y la valida.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 * @return la descripción del objeto ingresada por el usuario
	 */
	public static String getDescription(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Ingrese la descripción: ");
				String description = scanner.next();
				if (description != null && !description.trim().isEmpty()) {
					return description;
				} else {
					System.out.println("La descripción es requerida.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: La descripción debe ser una cadena.");
				scanner.next(); // Limpiar el buffer
			}
		}
	}

	/**
	 * Solicita el precio del objeto al usuario y lo valida.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 * @return el precio del objeto ingresado por el usuario
	 */
	public static float getPrice(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Ingrese el precio: ");
				if (scanner.hasNextFloat()) {
					float price = scanner.nextFloat();
					if (price > 0) {
						return price;
					} else {
						System.out.println("El precio debe ser mayor que cero.");
					}
				} else {
					System.out.println("El precio debe ser un número.");
					scanner.next(); // Limpiar el buffer
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: El precio debe ser un número.");
				scanner.next(); // Limpiar el buffer
			}
		}
	}

	/**
	 * Solicita el ID del objeto al usuario y lo valida.
	 * 
	 * @param scanner objeto {@link Scanner} para leer la entrada del usuario
	 * @return el ID del objeto ingresado por el usuario
	 */
	public static int getId(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Ingrese el ID: ");
				if (scanner.hasNextInt()) {
					int id = scanner.nextInt();
					if (id > 0) {
						return id;
					} else {
						System.out.println("El ID debe ser mayor que cero.");
					}
				} else {
					System.out.println("El ID debe ser un número.");
					scanner.next(); // Limpiar el buffer
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: El ID debe ser un número.");
				scanner.next(); // Limpiar el buffer
			}
		}
	}

	/**
	 * Verifica si una cantidad es válida.
	 * 
	 * @param amount la cantidad a validar
	 * @return la cantidad válida
	 */
	public static int getAmount() {
		String amount;
		while (true) {
			try {
				System.out.print("Ingrese una cantidad: ");
				amount = System.console().readLine();
				// Lógica para validar la cantidad
				// Por ejemplo, verificando que sea un número entero positivo
				int amountInt = Integer.parseInt(amount);
				if (amountInt > 0) {
					return amountInt;
				} else {
					System.out.println("Cantidad inválida. Intente nuevamente.");
				}
			} catch (NumberFormatException e) {
				// Manejar excepción en caso de que la cantidad no sea un número entero
				System.err.println("La cantidad debe ser un número entero");
			}
		}
	}
}