package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase PersonaDTO representa las personas del aplicativo (Ciclicsta,
 * Masajista, Director deportivo). Contiene la informacion sobre el nombre,
 * identificador y años de experiencia de la persona.
 */
public class PersonaDTO extends UsuarioDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 3738045143219242103L;

	/**
	 * Contiene los atributos de la persona.
	 */
	private String nombre;
	private long identificador;
	private int aniosExp;
	private String nacionalidad;

	/**
	 * Constructor por defecto de la clase PersonaDTO.
	 */
	public PersonaDTO() {
	}

	public PersonaDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.aniosExp = aniosExp;
		this.nacionalidad = nacionalidad;
	}

	public PersonaDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id, String nombre,
			long identificador, int aniosExp, String nacionalidad) {
		super(usuario, clave, tipoDeUsuario, correo, id);
		this.nombre = nombre;
		this.identificador = identificador;
		this.aniosExp = aniosExp;
		this.nacionalidad = nacionalidad;
	}

	public PersonaDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id) {
		super(usuario, clave, tipoDeUsuario, correo, id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public int getAniosExp() {
		return aniosExp;
	}

	public void setAniosExp(int aniosExp) {
		this.aniosExp = aniosExp;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	

}
