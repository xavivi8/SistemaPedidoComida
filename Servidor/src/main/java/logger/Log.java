package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Objetivo: Crear un logger
 * autor: Francisco Javier Martín-Lunas Escobar
 * fecha: 23/02/2024
 */
public class Log {
	private static final Logger logger = Logger.getLogger(Log.class.getName());
	private FileHandler fileHandler;

	/**
	 * Constructor
	 * 
	 * @param logFileName
	 */
	public Log(String logFileName) {
		try {

			fileHandler = new FileHandler(logFileName);
			logger.addHandler(fileHandler); // para el nombre del fichero
			logger.setLevel(Level.ALL); // Para que haga log de cualquier cosa que pasa
			SimpleFormatter formatter = new SimpleFormatter(); // Para el formato
			fileHandler.setFormatter(formatter);
		} catch (IOException e) {
			System.err.println("Error creando el log: " + e.getMessage());
		}
	}

	/**
	 * Le paso el mensaje que quiero que guarde, para en el log
	 * 
	 * @param message
	 */
	public void logConnection(String message) {
		logger.info(message);

	}

	/**
	 * 
	 * @param message
	 * @param throwable
	 */
	public void logError(String message, Throwable throwable) {
		logger.log(Level.SEVERE, message, throwable);
	}

	/**
	 * 
	 */
	public void closeLogger() {
		if (fileHandler != null) {
			fileHandler.close();
		}
	}
}
