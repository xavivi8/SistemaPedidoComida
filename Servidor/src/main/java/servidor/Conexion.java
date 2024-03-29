package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Objetivo: Clase que gestiona la conexión del servidor con los clientes.
 * autor: Francisco Javier Martín-Lunas Escobar
 * fecha: 03/03/2024	
 */
public class Conexion {
	
	private static final int PUERTO = 2024;
	
	/**
	 * Establece la conexión del servidor en el puerto especificado y gestiona la llegada de clientes.
	 */
	public void conexion() {
		try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
			System.out.println("Servidor en puerto: " + PUERTO);

			while (true) {

				Socket clientSocket = serverSocket.accept();
				clientSocket.setSoTimeout(50000);
				System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

				Hilo clientThread = new Hilo(clientSocket);
				clientThread.start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
