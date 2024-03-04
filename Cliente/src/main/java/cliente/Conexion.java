package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Conexion {
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PUERTO = 2024;
	private static Socket socket;

	public void conexion() {
		try {
            socket = new Socket(SERVER_IP, PUERTO);
            System.out.println("Conexión establecida con el servidor.");

            // Hilo para recibir mensajes del servidor
            Thread recibirMensajesThread = new Thread(() -> {
                try {
                    recibirMensajes(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            recibirMensajesThread.start();

            // Hilo para enviar mensajes al servidor
            Thread enviarMensajesThread = new Thread(() -> {
                try {
                    enviarMensajes(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            enviarMensajesThread.start();

            // Espera a que ambos hilos terminen
            recibirMensajesThread.join();
            enviarMensajesThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	private static void enviarMensaje(Socket socket, String mensaje) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(mensaje);
    }

    private static void enviarMensajes(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String mensaje;

        while (true) {
            System.out.print("Cliente: ");
            mensaje = reader.readLine();
            enviarMensaje(socket, mensaje);
        }
    }

    private static void recibirMensajes(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String mensaje;

        while ((mensaje = reader.readLine()) != null) {
            System.out.println("Servidor: " + mensaje);
        }
    }
}
