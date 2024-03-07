package servidor;

/**
 * Objetivo: Proporciona funciones auxiliares para el servidor. 
 * autor: Francisco Javier Martín-Lunas Escobar
 * fecha: 03/03/2024	
 */
public class Funciones {
	
	/**
	 * Genera el menú para administradores.
	 * @return el menú para administradores
	 */
	public static String menuUsuario() {
		return "===== Pedir comida ===== "
				+ "\n Ver comidas disponibles 1) "
				+ "\n Pedir comida 2) "
				+ "\n Terminar 0)";
	}
	
	/**
	 * Genera el menú para administradores.
	 * @return el menú para administradores
	 */
	public static String menuAdmin() {
		return "===== Menú administración ===== "
				+ "\n Rellenar comidas 1)"
				+ "\n Pedir comidas 2)"
				+ "\n Terminar 0)";
	}
	
	/**
	 * Genera el menú para rellenar comidas.
	 * @return el menú para rellenar comidas
	 */
	public static String menuRellenarComida() {
		return "===== Menú rellenar comidas ====="
				+ "\n Ver comidas 1)"
				+ "\n Rellenar comidas 2)"
				+ "\n Añadir comida 3)"
				+ "\n Quitar comida 4)"
				+ "\n Finalizar rellenado 5)"
				+ "\n Terminar 0)";
	}
	
	/**
	 * Divide una cadena utilizando como delimitador la coma (,).
	 * @param input la cadena a dividir
	 * @return un array de Strings que contiene las subcadenas resultantes
	 */
	public static String[] splitByComma(String input) {
		return input.split(",");
	}
}
