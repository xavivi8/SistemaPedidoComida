package bdControler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
	
	// Constructor con todos los campos
	public Comida(int idComida, String nombre, int cantidad) {
		this.idComida = idComida;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	// Constructor sin el campo idComida
	public Comida(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	// Getters y Setters
	public int getIdComida() {
		return idComida;
	}

	public void setIdComida(int idComida) {
		this.idComida = idComida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
