package servidor;

import java.net.Socket;

public class Hilo extends Thread{
	
	private Socket clienteSocket;
	
	public Hilo(Socket socket) {
		this.clienteSocket = socket;
	}
	
	public void run() {
		
	}
}
