package co.edu.unbosque.model;

import java.io.Serializable;

public class CiclistaClasicomanoDTO extends CiclistaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -97396303666102691L;
	private int numeroClasicosGanados;

	public CiclistaClasicomanoDTO() {
	}

	public CiclistaClasicomanoDTO(int numeroClasicosGanados) {
		super();
		this.numeroClasicosGanados = numeroClasicosGanados;
	}

	public CiclistaClasicomanoDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo, int numeroClasicosGanados) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		this.numeroClasicosGanados = numeroClasicosGanados;
	}

	public CiclistaClasicomanoDTO(String nombre, long identificador, int aniosExp, String tipoCiclista,
			String contextura, double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad,
			int numeroClasicosGanados) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		this.numeroClasicosGanados = numeroClasicosGanados;
	}

	public CiclistaClasicomanoDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			int numeroClasicosGanados) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.numeroClasicosGanados = numeroClasicosGanados;
	}

	public CiclistaClasicomanoDTO(String nombre, long identificador, int aniosExp, String tipoCiclista,
			String contextura, double tiempoAcumulado, String especialidad, String cadenciaPedaleo,
			String nacionalidad) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaClasicomanoDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaClasicomanoDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		// TODO Auto-generated constructor stub
	}

	public int getNumeroClasicosGanados() {
		return numeroClasicosGanados;
	}

	public void setNumeroClasicosGanados(int numeroClasicosGanados) {
		this.numeroClasicosGanados = numeroClasicosGanados;
	}

	@Override
	public String toString() {
		return "CiclistaClasicomanoDTO [numeroClasicosGanados=" + numeroClasicosGanados + ", getTipoCiclista()="
				+ getTipoCiclista() + ", getContextura()=" + getContextura() + ", getTiempoAcumulado()="
				+ getTiempoAcumulado() + ", getEspecialidad()=" + getEspecialidad() + ", getCadenciaPedaleo()="
				+ getCadenciaPedaleo() + ", getNombre()=" + getNombre() + ", getIdentificador()=" + getIdentificador()
				+ ", getAniosExp()=" + getAniosExp() + ", getNacionalidad()=" + getNacionalidad() + "]";
	}

}
