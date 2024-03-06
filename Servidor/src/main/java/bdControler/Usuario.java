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
	
	public Usuario() {
		
	}
	
	// Constructor con todos los campos
	public Usuario(int idUsuario, int rol, String nombre, String pass,String apellido1, String apellido2) {
		this.idUsuario = idUsuario;
		this.rol = rol;
		this.nombre = nombre;
		this.pass = pass;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	// Constructor sin el campo idUsuario
	public Usuario(int rol, String nombre, String apellido1, String apellido2) {
		this.rol = rol;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	// Getters y setters
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
}
