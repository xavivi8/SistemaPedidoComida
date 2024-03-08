package servidor;

/**
 * La clase MainServidor es la clase principal que contiene el método main para ejecutar la aplicación del servidor.
 */
public class MainServidor {

	/**
	 * El método main es el punto de entrada de la aplicación del servidor.
	 * 
	 * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Se crea una instancia de la clase Conexion para establecer la conexión.
		Conexion conexion = new Conexion();
		
		try {
			// Se intenta establecer la conexión llamando al método conexion().
			conexion.conexion();

		} catch (Exception e) {
			// Si ocurre una excepción, se imprime el mensaje de la excepción.
			System.out.println(e);
			// TODO: manejar la excepción adecuadamente según los requisitos de la aplicación.
		}
	}

}
