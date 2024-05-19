package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase DirectorDeportivoDTO representa los directores deportivos del
 * aplicativo. Contiene la informacion sobre el nombre, identificador, años de
 * experiencia, entre otros atributos para el director deportivo.
 */
public class DirectorDeportivoDTO extends PersonaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 8508488553819162865L;
	private String nombreEscuadra;

	/**
	 * Constructor por defecto de la clase PersonaDTO.
	 */
	public DirectorDeportivoDTO() {
	}

	public DirectorDeportivoDTO(String lista) {
		super();
		this.nombreEscuadra = lista;
	}

	public DirectorDeportivoDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			String nombreEscuadra) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.nombreEscuadra = nombreEscuadra;
	}

	public DirectorDeportivoDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id,
			String nombre, long identificador, int aniosExp, String nacionalidad, String nombreEscuadra) {
		super(usuario, clave, tipoDeUsuario, correo, id, nombre, identificador, aniosExp, nacionalidad);
		this.nombreEscuadra = nombreEscuadra;
	}

	public DirectorDeportivoDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id,
			String nombreEscuadra) {
		super(usuario, clave, tipoDeUsuario, correo, id);
		this.nombreEscuadra = nombreEscuadra;
	}

	public DirectorDeportivoDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public DirectorDeportivoDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id,
			String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(usuario, clave, tipoDeUsuario, correo, id, nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public DirectorDeportivoDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id) {
		super(usuario, clave, tipoDeUsuario, correo, id);
		// TODO Auto-generated constructor stub
	}

	public String getNombreEscuadra() {
		return nombreEscuadra;
	}

	public void setNombreEscuadra(String nombreEscuadra) {
		this.nombreEscuadra = nombreEscuadra;
	}
	
	


}
