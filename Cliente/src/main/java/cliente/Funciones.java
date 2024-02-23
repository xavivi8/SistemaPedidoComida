package cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Funciones {

	private static void enviarMensaje(Socket socket, String mensaje) throws IOException {
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		writer.println(mensaje);

	}
}
