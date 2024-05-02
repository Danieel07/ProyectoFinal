package co.edu.unbosque.model;

import java.io.Serializable;

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

	/**
	 * Constructor por defecto de la clase PersonaDTO.
	 */
	public DirectorDeportivoDTO() {
	}

	/**
	 * Contructor heredado con solo lso atributos de la superClase.
	 * 
	 * @param nombre
	 * @param identificador
	 * @param aniosExp
	 * @param nacionalidad
	 */
	public DirectorDeportivoDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Devuelve una representacion en cadena de los atributos.
	 * 
	 * @return Una cadena que representa la persona.
	 */
	@Override
	public String toString() {
		return "DirectorDeportivoDTO [getNombre()=" + getNombre() + ", getIdentificador()=" + getIdentificador()
				+ ", getAniosExp()=" + getAniosExp() + ", getNacionalidad()=" + getNacionalidad() + "]";
	}

}
