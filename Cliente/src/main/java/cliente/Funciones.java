package cliente;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Objetivo: Funciones comunes
 * Autor: Francisco Javier Martín-Lunas Escobar
 * Fecha: 06/03/2024
 */
public class Funciones {
	/**
	 * Divide una cadena en subcadenas utilizando como delimitador la coma (,).
	 * @param input la cadena a dividir
	 * @return un array de Strings que contiene las subcadenas resultantes
	 */
	public static String[] splitByComma(String input) {
		return input.split(",");
	}
}
