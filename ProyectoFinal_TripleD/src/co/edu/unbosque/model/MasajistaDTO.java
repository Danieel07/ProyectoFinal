package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase MasajistaDTO representa los masajistas del aplicativo. Contiene la
 * informacion sobre el nombre, identificador y años de experiencia de los
 * masajistas.
 */

public class MasajistaDTO extends PersonaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 7014855633358568493L;

	/**
	 * Constructor por defecto de la clase PersonaDTO.
	 */
	public MasajistaDTO() {
	}

	/**
	 * Contructor heredado con solo lso atributos de la superClase.
	 * 
	 * @param nombre
	 * @param identificador
	 * @param aniosExp
	 * @param nacionalidad
	 */
	public MasajistaDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Devuelve una representacion en cadena de los atributos.
	 * 
	 * @return Una cadena que representa los masajistas.
	 */
	@Override
	public String toString() {
		return "Masajista: \n Nombre:" + getNombre() + "\n Cedula:" + getIdentificador() + "\n Años Experiencia:"
				+ getAniosExp() + "\n Nacionalidad:" + getNacionalidad() + "\n";
	}

}
