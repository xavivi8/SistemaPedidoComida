package servidor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import bdControler.Comida;
import bdControler.Servicio;
import logger.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Hilo extends Thread {
	private static Configuration config = new Configuration();
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();
	private static Servicio servicio = new Servicio();
	private static Log logger = new Log("log.txt");
	private Socket clienteSocket;

	public Hilo(Socket socket) {
		this.clienteSocket = socket;
	}

	public void run() {
		logger.logConnection("IP conectada: " + clienteSocket.getInetAddress());
		int rolUsuario = -1;
		/**
		 * Bucle que comprueba que este logeado
		 */
		boolean logeado = false;
		do {
			String input = "awdwaw,efesf";
			String[] result = splitByComma(input);
			rolUsuario = servicio.obtenerRolUsuario(result[0], result[1]);
			if (rolUsuario >= 0) {
				logeado = true;
			}
		} while (logeado == false);

		/**
		 * Control de roll
		 */
		int opcion = -1;
		if (rolUsuario == 1) {
			do {

				opcion = menuAdmin();

			} while (opcion != 0);
		} else {
			do {

				opcion = menuUsuario();

			} while (opcion != 0);
		}

	}

	private String getClientNameFromSocket() throws IOException {
		// Obtenemos el flujo de entrada del socket para leer el nombre del cliente.
		BufferedReader input = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
		return input.readLine(); // Suponiendo que el cliente envía su nombre como una línea de texto.
	}

	private static String[] splitByComma(String input) {
		return input.split(",");
	}

	private void enviarMensajeCliente(String mensaje) {
		try {
			// Obtenemos el OutputStream del socket cliente
			PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
			// Enviamos el mensaje al cliente
			out.println(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Control del menu de administrador */

	private int menuAdmin() {
		int opcion = -1;
		try {
			do {
				if (opcion != 0) {
					enviarMensajeCliente(Funciones.menuAdmin());
					String vuelta = getClientNameFromSocket();
					opcion = Integer.parseInt(vuelta);
					switch (opcion) {
					case 1:
						opcion = menuRellenarComida();
						break;
					case 2:
						opcion = menuUsuario();
						break;
					default:
						enviarMensajeCliente("Opción no válida");
						break;
					}
				}

			} while (opcion != 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opcion;
	}

	/* Control del menu de usuarios */

	private int menuUsuario() {
		int opcion = -1;
		try {
			do {
				if (opcion != 0) {
					enviarMensajeCliente(Funciones.menuUsuario());
					String vuelta;
					vuelta = getClientNameFromSocket();
					opcion = Integer.parseInt(vuelta);

					switch (opcion) {
					case 0:
						enviarMensajeCliente("Tenga un buen día");
						break;
					case 1:
						enviarMensajeCliente(listaComida());
						break;
					case 2:
						enviarMensajeCliente(
								"Inserte el nombre y la cantidad de comida que desea de esta manera: empanadilla,23");
						vuelta = getClientNameFromSocket();
						enviarMensajeCliente(pedirComida(vuelta));
						break;
					default:
						enviarMensajeCliente("Opción no válida");
						break;
					}
				}
			} while (opcion != 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opcion;
	}

	private String listaComida() {
		List<Comida> lsitaDeComida = servicio.obtenerTodasLasComidas();
		StringBuilder resultado = new StringBuilder();

		if (lsitaDeComida == null) {
			return "No hay comidas disponibles";
		}

		for (Comida comida : lsitaDeComida) {
			String nombre = comida.getNombre();
			int cantidad = comida.getCantidad();
			resultado.append("Comida: ").append(nombre).append(" Cantidad: ").append(cantidad).append("\n");
		}

		return resultado.toString();
	}

	private String pedirComida(String mensaje) {
		String[] result = splitByComma(mensaje);

		String confirmacion = servicio.cogerComida(result[0], Integer.parseInt(result[1]));

		return confirmacion;
	}

	/* Control del menú rellenar comida */

	private int menuRellenarComida() {
		int opcion = -1;
		try {
			do {
				if (opcion != 0) {
					enviarMensajeCliente(Funciones.menuRellenarComida());
					String vuelta;
					vuelta = getClientNameFromSocket();
					opcion = Integer.parseInt(vuelta);

					switch (opcion) {
					case 0:
						enviarMensajeCliente("Tenga un buen día");
						break;
					case 1:
						enviarMensajeCliente(listaComida());
						break;
					case 2:
						enviarMensajeCliente(
								"Inserte el nombre y la cantidad de comida que desea rellenar de esta manera: empanadilla,23");
						vuelta = getClientNameFromSocket();
						enviarMensajeCliente(rellenarComida(vuelta));
						break;
					case 3:
						enviarMensajeCliente("Inserte la comida que quiera añadir");
						vuelta = getClientNameFromSocket();
						enviarMensajeCliente(servicio.anyadirComida(vuelta));
						break;
					case 4:
						enviarMensajeCliente("Inserte la comida que quiera añadir");
						vuelta = getClientNameFromSocket();
						enviarMensajeCliente(servicio.eliminarComida(vuelta));
						break;
					case 5:
						enviarMensajeCliente("Saliendo del menu de administración");
						break;
					default:
						enviarMensajeCliente("Opción no válida");
						break;
					}
				}
			} while (opcion != 0 && opcion != 5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opcion;
	}
	
	private String rellenarComida(String mensaje) {
		String[] result = splitByComma(mensaje);
		
		String confirmacion = servicio.rellenarComida(result[0], Integer.parseInt(result[1]));
		
		return "";
	}
	

}
