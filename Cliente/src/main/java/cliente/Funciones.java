package cliente;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Objetivo:
 * Autor: Francisco Javier Martín-Lunas Escobar
 * Fecha: 06/03/2024
 */
public class Funciones {

	/**
	 * Este método cifra la contraseña proporcionada utilizando el algoritmo de hash MD5.
	 * 
	 * @param laContraseña La contraseña que se va a cifrar.
	 * @return La representación hexadecimal del hash MD5 de la contraseña.
	 */
	public static String cifrarContraseñaConMd5(String laContraseña) {
		/*
		 * Nota del alumno MessageDigest: La clase MessageDigest en Java es una parte
		 * importante de la biblioteca de -seguridad que se utiliza para calcular
		 * resúmenes criptográficos (hash) de datos, -como contraseñas o mensajes.
		 * Proporciona la funcionalidad para aplicar algoritmos -de hash criptográficos,
		 * como MD5, SHA-1, SHA-256, y otros.
		 * 
		 * .digest:en Java se utiliza en combinación con la clase MessageDigest para
		 * calcular un resumen (hash) de los datos proporcionados.
		 * 
		 */
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(laContraseña.getBytes());

			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {// recorre el array que contiene el hash de MD5
				sb.append(String.format("%02x", b));// combierte a hexadecimnal de dos caracteres
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] splitByComma(String input) {
		return input.split(",");
	}
}
