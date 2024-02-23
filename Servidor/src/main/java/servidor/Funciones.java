package servidor;

public class Funciones {

	public static String menuUsuario() {
		return "===== Pedir comida ===== "
				+ "\n Ver comidas disponibles 1) "
				+ "\n Pedir comida 2) "
				+ "\n Terminar 0)";
	}
	
	public static String menuAdmin() {
		return "===== Menú administración ===== "
				+ "\n Rellenar comidas 1)"
				+ "\n Pedir comidas 2)"
				+ "\n Terminar 0)";
	}
	
	public static String menuRellenarComida() {
		return "===== Menú rellenar comidas ====="
				+ "\n Ver comidas 1)"
				+ "\n Rellenar comidas 2)"
				+ "\n Finalizar rellenado 3)"
				+ "\n Terminar 0)";
	}
}
