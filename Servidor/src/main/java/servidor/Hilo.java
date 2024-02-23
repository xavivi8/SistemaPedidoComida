package servidor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import bdControler.Servicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilo extends Thread{
	private static Configuration config = new Configuration();
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static Servicio servicio = new Servicio();
	private Socket clienteSocket;
	
	public Hilo(Socket socket) {
		this.clienteSocket = socket;
	}
	
	public void run() {
		int rolUsuario = -1;
		/**
		 * Bucle que comprueba que este logeado
		 */
		boolean logeado = false;
		do {
			String input = "awdwaw,efesf";
	        String[] result = splitByComma(input);
			rolUsuario = servicio.obtenerRolUsuario(result[0],result[1]);
			if(rolUsuario >= 0) {
				logeado = true;
			}
		}while(logeado == false);
		
		/**
		 * Control de roll
		 */
		int opcion = -1;
		if(rolUsuario == 1) {
			do {
				System.out.println(Funciones.menuAdmin());
			}while(opcion != 0);
		} else {
			do {
				
			}while(opcion != 0);
		}
		
	    
		
	}
	
	private String getClientNameFromSocket() throws IOException {
        // Obtenemos el flujo de entrada del socket para leer el nombre del cliente.
        BufferedReader input = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        return input.readLine(); // Suponiendo que el cliente envía su nombre como una línea de texto.
    }
	
	public static String[] splitByComma(String input) {
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
	
	
}
