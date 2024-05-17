package co.edu.unbosque.model;

import java.io.Serializable;

public class CiclistaGregarioDTO extends CiclistaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6517558207953781810L;
	private String funcionPeloton; // Puede ser Abastecedor, mantener ritmo, captura de fugas, posicionar lider y
									// proteger lider.

	public CiclistaGregarioDTO() {
	}

	public CiclistaGregarioDTO(String funcionPeloton) {
		super();
		this.funcionPeloton = funcionPeloton;
	}

	public CiclistaGregarioDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo, String funcionPeloton) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		this.funcionPeloton = funcionPeloton;
	}

	public CiclistaGregarioDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad,
			String funcionPeloton) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		this.funcionPeloton = funcionPeloton;
	}

	public CiclistaGregarioDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			String funcionPeloton) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.funcionPeloton = funcionPeloton;
	}

	public CiclistaGregarioDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaGregarioDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaGregarioDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		// TODO Auto-generated constructor stub
	}

	public String getFuncionPeloton() {
		return funcionPeloton;
	}

	public void setFuncionPeloton(String funcionPeloton) {
		this.funcionPeloton = funcionPeloton;
	}

	@Override
	public String toString() {
		return "CiclistaGregarioDTO [funcionPeloton=" + funcionPeloton + ", getTipoCiclista()=" + getTipoCiclista()
				+ ", getContextura()=" + getContextura() + ", getTiempoAcumulado()=" + getTiempoAcumulado()
				+ ", getEspecialidad()=" + getEspecialidad() + ", getCadenciaPedaleo()=" + getCadenciaPedaleo()
				+ ", getNombre()=" + getNombre() + ", getIdentificador()=" + getIdentificador() + ", getAniosExp()="
				+ getAniosExp() + ", getNacionalidad()=" + getNacionalidad() + "]";
	}

}
