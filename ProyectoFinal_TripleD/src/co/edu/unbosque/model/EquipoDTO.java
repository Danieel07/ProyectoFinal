package co.edu.unbosque.model;

import java.io.Serializable;

public class EquipoDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 8538633720034250589L;

	/**
	 * Contiene los atributos de los equipos.
	 */
	private String nombre;
	private String pais;
	private double sumaTiempo;// En minutos

	// Al menos 7 ciclista con rol diferente

	/**
	 * Constructor por defecto de la clase EquipoDTO.
	 */
	public EquipoDTO() {
	}

	/**
	 * Constructor por defecto que inciializa los atributos.
	 * 
	 * @param nombre
	 * @param pais
	 * @param sumaTiempo
	 */
	public EquipoDTO(String nombre, String pais, double sumaTiempo) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.sumaTiempo = sumaTiempo;
	}

	/**
	 * Obtiene el nombre del equipo.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nuevo nombre de el equipo.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el pais correspondiente del equipo.
	 * 
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Establece el pais correspondiente del equipo.
	 * 
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Obetiene la suma de el tiempo del equipo en minutos.
	 * 
	 * @return sumaTiempo
	 */
	public double getSumaTiempo() {
		return sumaTiempo;
	}

	/**
	 * Establece la suma del tiempo del equipo en minutos.
	 * 
	 * @param sumaTiempo
	 */
	public void setSumaTiempo(double sumaTiempo) {
		this.sumaTiempo = sumaTiempo;
	}

	/**
	 * Devuelve una representacion en cadena de los atributos.
	 * 
	 * @return Una cadena que representa los equipos.
	 */
	@Override
	public String toString() {
		return "Equipos: \n Nombre:" + nombre + "\n País:" + pais + "\n Suma Tiempo en minutos:" + sumaTiempo + "\n";
	}

}
