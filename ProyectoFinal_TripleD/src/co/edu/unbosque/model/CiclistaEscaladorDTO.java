package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase CiclistaEscaladorDTO representa el ciclista de tipo escalador del
 * aplicativo. Contiene la informacion sobre las clases heredadas del escalador.
 */
public class CiclistaEscaladorDTO extends CiclistaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 2931030728969899804L;
	private String aceleracionPromSubida;
	private int gradoRampaSoportada; // grados

	public CiclistaEscaladorDTO() {
	}

	public CiclistaEscaladorDTO(String aceleracionPromSubida, int gradoRampaSoportada) {
		super();
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public CiclistaEscaladorDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo, String aceleracionPromSubida, int gradoRampaSoportada) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public CiclistaEscaladorDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad,
			String aceleracionPromSubida, int gradoRampaSoportada) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public CiclistaEscaladorDTO(String nombre, long identificador, int aniosExp, String nacionalidad,
			String aceleracionPromSubida, int gradoRampaSoportada) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.aceleracionPromSubida = aceleracionPromSubida;
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public CiclistaEscaladorDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad) {
		super(nombre, identificador, aniosExp, tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo,
				nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaEscaladorDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public CiclistaEscaladorDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo) {
		super(tipoCiclista, contextura, tiempoAcumulado, especialidad, cadenciaPedaleo);
		// TODO Auto-generated constructor stub
	}

	public String getAceleracionPromSubida() {
		return aceleracionPromSubida;
	}

	public void setAceleracionPromSubida(String aceleracionPromSubida) {
		this.aceleracionPromSubida = aceleracionPromSubida;
	}

	public int getGradoRampaSoportada() {
		return gradoRampaSoportada;
	}

	public void setGradoRampaSoportada(int gradoRampaSoportada) {
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	@Override
	public String toString() {
		return "Ciclista Escalador: \n Aceleracion Promedio En Subida:" + aceleracionPromSubida
				+ "\n Grado De Rampa Soportada:" + gradoRampaSoportada + "\n Tipo de Ciclista: " + getTipoCiclista()
				+ "\n Contextura: " + getContextura() + "\n Tiempo Acumulado: " + getTiempoAcumulado()
				+ "\n Especialidad: " + getEspecialidad() + "\n Cadencia de Pedaleo: " + getCadenciaPedaleo()
				+ "\n Nombre: " + getNombre() + "\n Identificador: " + getIdentificador() + "\n Años de Experiencia: "
				+ getAniosExp() + "\n Nacionalidad:" + getNacionalidad();
	}

}
