package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase MasajistaDTO representa los masajistas del aplicativo. Contiene la
 * informacion sobre el nombre, identificador y años de experiencia de los
 * masajistas.
 */

public class MasajistaDTO extends PersonaDTO implements Serializable {
	private String llenoDatos;
	
	
	public MasajistaDTO() {
		// TODO Auto-generated constructor stub
	}


	public MasajistaDTO(String llenoDatos) {
		super();
		this.llenoDatos = llenoDatos;
	}


	public MasajistaDTO(String nombre, long identificador, int aniosExp, String nacionalidad, String llenoDatos) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.llenoDatos = llenoDatos;
	}


	public MasajistaDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id, String nombre,
			long identificador, int aniosExp, String nacionalidad, String llenoDatos) {
		super(usuario, clave, tipoDeUsuario, correo, id, nombre, identificador, aniosExp, nacionalidad);
		this.llenoDatos = llenoDatos;
	}


	public MasajistaDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id, String llenoDatos) {
		super(usuario, clave, tipoDeUsuario, correo, id);
		this.llenoDatos = llenoDatos;
	}


	public MasajistaDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}


	public MasajistaDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id, String nombre,
			long identificador, int aniosExp, String nacionalidad) {
		super(usuario, clave, tipoDeUsuario, correo, id, nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}


	public MasajistaDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id) {
		super(usuario, clave, tipoDeUsuario, correo, id);
		// TODO Auto-generated constructor stub
	}


	public String getLlenoDatos() {
		return llenoDatos;
	}


	public void setLlenoDatos(String llenoDatos) {
		this.llenoDatos = llenoDatos;
	}
	
}
