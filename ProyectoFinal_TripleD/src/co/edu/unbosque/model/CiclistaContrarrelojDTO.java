package co.edu.unbosque.model;

import java.io.Serializable;

public class CiclistaContrarrelojDTO extends CiclistaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -8012248480180628269L;
	private double velocidadMax; // km/h

	public CiclistaContrarrelojDTO() {
	}

	public CiclistaContrarrelojDTO(double velocidadMax) {
		super();
		this.velocidadMax = velocidadMax;
	}

	public CiclistaContrarrelojDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo, double velocidadMax) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		this.velocidadMax = velocidadMax;
	}

	public CiclistaContrarrelojDTO(String nombre, long identificador, int aniosExp, String tipoCiclista,
			String contextura, double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad,
			double velocidadMax) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		this.velocidadMax = velocidadMax;
	}

	public CiclistaContrarrelojDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			double velocidadMax) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.velocidadMax = velocidadMax;
	}

	public CiclistaContrarrelojDTO(String nombre, long identificador, int aniosExp, String tipoCiclista,
			String contextura, double tiempoAcumulado, String especialidad, String cadenciaPedaleo,
			String nacionalidad) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaContrarrelojDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaContrarrelojDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		// TODO Auto-generated constructor stub
	}

	public double getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(double velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	@Override
	public String toString() {
		return "CiclistaContrarrelojDTO [velocidadMax=" + velocidadMax + ", getTipoCiclista()=" + getTipoCiclista()
				+ ", getContextura()=" + getContextura() + ", getTiempoAcumulado()=" + getTiempoAcumulado()
				+ ", getEspecialidad()=" + getEspecialidad() + ", getCadenciaPedaleo()=" + getCadenciaPedaleo()
				+ ", getNombre()=" + getNombre() + ", getIdentificador()=" + getIdentificador() + ", getAniosExp()="
				+ getAniosExp() + ", getNacionalidad()=" + getNacionalidad() + "]";
	}

}
