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
	private ArrayList<CiclistaDTO> lista;

	/**
	 * Constructor por defecto de la clase PersonaDTO.
	 */
	public DirectorDeportivoDTO() {
	}

	public DirectorDeportivoDTO(ArrayList<CiclistaDTO> lista) {
		super();
		this.lista = lista;
	}

	public DirectorDeportivoDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			ArrayList<CiclistaDTO> lista) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.lista = lista;
	}

	public DirectorDeportivoDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<CiclistaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CiclistaDTO> lista) {
		this.lista = lista;
	}

}
