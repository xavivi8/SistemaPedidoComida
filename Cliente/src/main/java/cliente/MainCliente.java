package cliente;

/**
 * La clase MainCliente es la clase principal que contiene el método main para ejecutar la aplicación del cliente.
 */
public class MainCliente {

	/**
	 * El método main es el punto de entrada de la aplicación del cliente.
	 * 
	 * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Se crea una instancia de la clase Conexion para establecer la conexión.
		Conexion conexion = new Conexion();
		
		// Se llama al método conexion para establecer la conexión.
		conexion.conexion();
	}

}
