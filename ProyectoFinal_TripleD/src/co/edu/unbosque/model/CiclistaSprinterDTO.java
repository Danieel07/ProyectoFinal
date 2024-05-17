package co.edu.unbosque.model;

import java.io.Serializable;

public class CiclistaSprinterDTO extends CiclistaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -8531353538871721655L;
	private String explosionMetrosFinales;
	private String potenciaProm; // En vatios
	private String velocidadPromSprint; // km/h

	public CiclistaSprinterDTO() {
	}

	public CiclistaSprinterDTO(String explosionMetrosFinales, String potenciaProm, String velocidadPromSprint) {
		super();
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaProm = potenciaProm;
		this.velocidadPromSprint = velocidadPromSprint;
	}

	public CiclistaSprinterDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo, String explosionMetrosFinales, String potenciaProm, String velocidadPromSprint) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaProm = potenciaProm;
		this.velocidadPromSprint = velocidadPromSprint;
	}

	public CiclistaSprinterDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad,
			String explosionMetrosFinales, String potenciaProm, String velocidadPromSprint) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaProm = potenciaProm;
		this.velocidadPromSprint = velocidadPromSprint;
	}

	public CiclistaSprinterDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			String explosionMetrosFinales, String potenciaProm, String velocidadPromSprint) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.explosionMetrosFinales = explosionMetrosFinales;
		this.potenciaProm = potenciaProm;
		this.velocidadPromSprint = velocidadPromSprint;
	}

	public CiclistaSprinterDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaSprinterDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaSprinterDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		// TODO Auto-generated constructor stub
	}

	public String getExplosionMetrosFinales() {
		return explosionMetrosFinales;
	}

	public void setExplosionMetrosFinales(String explosionMetrosFinales) {
		this.explosionMetrosFinales = explosionMetrosFinales;
	}

	public String getPotenciaProm() {
		return potenciaProm;
	}

	public void setPotenciaProm(String potenciaProm) {
		this.potenciaProm = potenciaProm;
	}

	public String getVelocidadPromSprint() {
		return velocidadPromSprint;
	}

	public void setVelocidadPromSprint(String velocidadPromSprint) {
		this.velocidadPromSprint = velocidadPromSprint;
	}

	@Override
	public String toString() {
		return "CiclistaSprinterDTO [explosionMetrosFinales=" + explosionMetrosFinales + ", potenciaProm="
				+ potenciaProm + ", velocidadPromSprint=" + velocidadPromSprint + ", getTipoCiclista()="
				+ getTipoCiclista() + ", getContextura()=" + getContextura() + ", getTiempoAcumulado()="
				+ getTiempoAcumulado() + ", getEspecialidad()=" + getEspecialidad() + ", getCadenciaPedaleo()="
				+ getCadenciaPedaleo() + ", getNombre()=" + getNombre() + ", getIdentificador()=" + getIdentificador()
				+ ", getAniosExp()=" + getAniosExp() + ", getNacionalidad()=" + getNacionalidad() + "]";
	}

}
