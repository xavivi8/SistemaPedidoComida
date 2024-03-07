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
 * Objetivo: Representa un usuario en la base de datos.
 * autor: Francisco Javier Martín-Lunas Escobar
 * fecha: 03/03/2024	
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "rol")
	private int rol;
	
	@Column(name = "pass")
	private String pass;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido1")
	private String apellido1;

	@Column(name = "apellido2")
	private String apellido2;

	/* Constructores */
	/**
	 * Constructor vacío de la clase Usuario.
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor de la clase Usuario.
	 * 
	 * @param idUsuario el ID del usuario
	 * @param rol el rol del usuario
	 * @param nombre el nombre del usuario
	 * @param pass la contraseña del usuario
	 * @param apellido1 el primer apellido del usuario
	 * @param apellido2 el segundo apellido del usuario
	 */
	public Usuario(int idUsuario, int rol, String nombre, String pass,String apellido1, String apellido2) {
		this.idUsuario = idUsuario;
		this.rol = rol;
		this.nombre = nombre;
		this.pass = pass;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	/**
	 * Constructor de la clase Usuario.
	 * 
	 * @param rol el rol del usuario
	 * @param nombre el nombre del usuario
	 * @param apellido1 el primer apellido del usuario
	 * @param apellido2 el segundo apellido del usuario
	 */
	public Usuario(int rol, String nombre, String apellido1, String apellido2) {
		this.rol = rol;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	// Getters y setters
	/**
	 * Devuelve el ID del usuario.
	 * 
	 * @return el ID del usuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Establece el ID del usuario.
	 * 
	 * @param idUsuario el ID del usuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * Devuelve el rol del usuario.
	 * 
	 * @return el rol del usuario
	 */
	public int getRol() {
		return rol;
	}

	/**
	 * Establece el rol del usuario.
	 * 
	 * @param rol el rol del usuario
	 */
	public void setRol(int rol) {
		this.rol = rol;
	}

	/**
	 * Devuelve el nombre del usuario.
	 * 
	 * @return el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre el nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el primer apellido del usuario.
	 * 
	 * @return el primer apellido del usuario
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Establece el primer apellido del usuario.
	 * 
	 * @param apellido1 el primer apellido del usuario
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Devuelve el segundo apellido del usuario.
	 * 
	 * @return el segundo apellido del usuario
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Establece el segundo apellido del usuario.
	 * 
	 * @param apellido2 el segundo apellido del usuario
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
}
