package co.edu.unbosque.model;

import java.io.Serializable;

public class CiclistaRodadorDTO extends CiclistaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -2331324238708283496L;
	private String velocidadPromPedaleo;

	public CiclistaRodadorDTO() {
		// TODO Auto-generated constructor stub
	}

	public CiclistaRodadorDTO(String velocidadPromPedaleo) {
		super();
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public CiclistaRodadorDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo, String velocidadPromPedaleo) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public CiclistaRodadorDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad,
			String velocidadPromPedaleo) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public CiclistaRodadorDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			String velocidadPromPedaleo) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	public CiclistaRodadorDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaRodadorDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaRodadorDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		// TODO Auto-generated constructor stub
	}

	public String getVelocidadPromPedaleo() {
		return velocidadPromPedaleo;
	}

	public void setVelocidadPromPedaleo(String velocidadPromPedaleo) {
		this.velocidadPromPedaleo = velocidadPromPedaleo;
	}

	@Override
	public String toString() {
		return "CiclistaRodadorDTO [velocidadPromPedaleo=" + velocidadPromPedaleo + ", getTipoCiclista()="
				+ getTipoCiclista() + ", getContextura()=" + getContextura() + ", getTiempoAcumulado()="
				+ getTiempoAcumulado() + ", getEspecialidad()=" + getEspecialidad() + ", getCadenciaPedaleo()="
				+ getCadenciaPedaleo() + ", getNombre()=" + getNombre() + ", getIdentificador()=" + getIdentificador()
				+ ", getAniosExp()=" + getAniosExp() + ", getNacionalidad()=" + getNacionalidad() + "]";
	}

}
