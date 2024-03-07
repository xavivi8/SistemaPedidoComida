package cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Conexion {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PUERTO = 2024;
    private static Socket socket;

    public void conexion() {
        try {
            socket = new Socket(SERVER_IP, PUERTO);
            System.out.println("Conexión establecida con el servidor.");

            // Envía los datos de inicio de sesión y espera la respuesta
            if (iniciarSesion(socket)) {
                // Si el inicio de sesión fue exitoso, continúa con los hilos de envío y recepción de mensajes
                Thread recibirMensajesThread = new Thread(() -> {
                    try {
                        recibirMensajes(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                recibirMensajesThread.start();

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
            } else {
                System.out.println("Inicio de sesión fallido. Saliendo...");
                socket.close();
            }

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

    private static boolean iniciarSesion(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader serverResponseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String respuesta = "";
        int intentos = 0;
        final int MAX_INTENTOS = 3;

        while (!respuesta.equals("Login exitoso") && intentos < MAX_INTENTOS) {
        	respuesta = serverResponseReader.readLine();
            System.out.println(respuesta);
            System.out.println("Ingrese su nombre de usuario:");
            String usuario = reader.readLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = reader.readLine();

            // Cifra la contraseña antes de enviarla
            String contrasenaCifrada = cifrarContrasena(contrasena);

            // Envía el nombre de usuario y la contraseña cifrada al servidor
            writer.println(usuario + "," + contrasenaCifrada);

            // Espera la respuesta del servidor para el inicio de sesión
            respuesta = serverResponseReader.readLine();
            System.out.println(respuesta);
            intentos++;
        }

        if (respuesta.equals("Login exitoso")) {
            return true;
        } else {
            System.out.println("Número máximo de intentos alcanzado. Inicio de sesión fallido.");
            return false;
        }
    }

    private static String cifrarContrasena(String contrasena) {
        // Implementa aquí tu lógica de cifrado de contraseñas
        // Por ejemplo, podrías usar MD5, SHA-256, etc.
        // Aquí se muestra un ejemplo simple de cifrado con MD5:
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(contrasena.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
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
            if (mensaje.equals("Tenga un buen día")) {
                System.out.println("Servidor: " + mensaje);
                System.out.println("Desconectando del servidor...");
                socket.close();
                System.exit(0);
                break;
            } else {
                System.out.println("Servidor: " + mensaje);
            }
        }
    }
}
