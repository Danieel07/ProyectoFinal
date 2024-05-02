package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase PersonaDTO representa las personas del aplicativo (Ciclicsta,
 * Masajista, Director deportivo). Contiene la informacion sobre el nombre,
 * identificador y años de experiencia de la persona.
 */
public class PersonaDTO implements Serializable {

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

	/**
	 * Contructor por defecto que inicializa el nombre, identificador y aniosExp de
	 * la persona.
	 * 
	 * @param nombre        El nombre de la persona
	 * @param identificador El identificador de la persona
	 * @param aniosExp      Los años de experiencia de la persona
	 */
	public PersonaDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.aniosExp = aniosExp;
		this.nacionalidad = nacionalidad;
	}

	/**
	 * Obtiene el nombre de la persona
	 * 
	 * @return nombre El nombre de la persona
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la persona
	 * 
	 * @param nombre
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el identificador de la persona
	 * 
	 * @return identificador El identificador de la persona
	 */

	public long getIdentificador() {
		return identificador;
	}

	/**
	 * Establece el identificador de la persona
	 * 
	 * @param identificador
	 */

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	/**
	 * Obtiene los años de experiencia de la persona
	 * 
	 * @return aniosExp Los años de experiencia de al persona
	 */

	public int getAniosExp() {
		return aniosExp;
	}

	/**
	 * Establece los años de experiencia de la persona
	 * 
	 * @param aniosExp Los nuevos años de experiencia de la persona
	 */

	public void setAniosExp(int aniosExp) {
		this.aniosExp = aniosExp;

	}

	/**
	 * Obtiene la nacionalidad de la persona
	 * 
	 * @return aniosExp Los años de experiencia de al persona
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * Establece los años de experiencia de la persona
	 * 
	 * @param nacionalidad La nueva nacionalidad de la persona
	 */

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * Devuelve una representacion en cadena de los atributos.
	 * 
	 * @return Una cadena que representa la persona.
	 */
	@Override
	public String toString() {
		return "Persona: Nombre:" + nombre + "\n Identificador: " + identificador + "\n Años de Experiencia:" + aniosExp
				+ "\n";
	}

}
