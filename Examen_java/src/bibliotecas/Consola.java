package bibliotecas;

import java.util.Scanner;

public class Consola {
	private static final boolean CON_ENTER = true;
	public static final boolean SIN_ENTER = false;

	private static Scanner s = new Scanner(System.in);

	public static Long pedirLong(String mensaje) {
		Long numero = null;
		String linea;

		do {
			p(mensaje + ": ", SIN_ENTER);

			linea = s.nextLine();

			try {
				numero = Long.parseLong(linea);
			} catch (NumberFormatException e) {
				p("Tienes que introducir un numero");
			}
		} while (numero == null);

		return numero;
	}

	public static Integer pedirInteger(String mensaje) {
		Integer numero = null;
		String linea;

		do {
			p(mensaje + " ", SIN_ENTER);

			linea = s.nextLine();

			try {
				numero = Integer.parseInt(linea);
			} catch (NumberFormatException e) {
				p("Tienes que introducir un numero");
			}
		} while (numero == null);

		return numero;
	}

	public static String pedirTexto(String mensaje) {
		p(mensaje + ": ", SIN_ENTER);

		return s.nextLine();
	}

	public static void cerrarConsola() {
		s.close();
	}
	
	public static void p(Object objeto, boolean conEnter) {
		if (conEnter) {
			System.out.println(objeto);
		} else {
			System.out.print(objeto);
		}
	}

	public static void p(Object objeto) {
		p(objeto, CON_ENTER);
	}

	public static void p() {
		System.out.println();
	}

}
