package bdControler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 * Objetivo: Representa la entidad de comida en la base de datos. 
 * autor: Francisco Javier Martín-Lunas Escobar
 * fecha: 03/03/2024	
 */
@Entity
@Table(name = "comida")
public class Comida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comida")
	private int idComida;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cantidad")
	private int cantidad;

	/* Constructores */
	public Comida() {
		
	}
	
	/**
	 * Constructor de la clase Comida que inicializa todos los atributos.
	 * 
	 * @param idComida el identificador de la comida
	 * @param nombre el nombre de la comida
	 * @param cantidad la cantidad de la comida
	 */
	public Comida(int idComida, String nombre, int cantidad) {
		this.idComida = idComida;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	/**
	 * Constructor de la clase Comida que inicializa los atributos nombre y cantidad.
	 * 
	 * @param nombre el nombre de la comida
	 * @param cantidad la cantidad de la comida
	 */
	public Comida(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	// Getters y Setters
	/**
	 * Devuelve el identificador de la comida.
	 * 
	 * @return el identificador de la comida
	 */
	public int getIdComida() {
		return idComida;
	}

	/**
	 * Establece el identificador de la comida.
	 * 
	 * @param idComida el identificador de la comida
	 */
	public void setIdComida(int idComida) {
		this.idComida = idComida;
	}
	
	/**
	 * Devuelve el nombre de la comida.
	 * 
	 * @return el nombre de la comida
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre de la comida.
	 * 
	 * @param nombre el nombre de la comida
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve la cantidad de la comida.
	 * 
	 * @return la cantidad de la comida
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Establece la cantidad de la comida.
	 * 
	 * @param cantidad la cantidad de la comida
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
