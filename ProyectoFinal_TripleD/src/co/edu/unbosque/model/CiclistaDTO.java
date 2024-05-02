package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase CiclistaDTO representa los ciclistas del aplicativo. Contiene la
 * informacion sobre el nombre, identificador, años de experiencia, entre otros
 * atributos para el ciclista.
 */
public class CiclistaDTO extends PersonaDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -8118555786749479844L;

	/**
	 * Contiene los atributos de la persona.
	 */
	private String tipoCiclista;
	private String contextura;
	private double tiempoAcumulado;
	private String especialidad;
	private String cadenciaPedaleo;

	/**
	 * Constructor por defecto de la clase PersonaDTO.
	 */
	public CiclistaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor por defecto que inicializa el tipoCiclista, contextura,
	 * tiempoAcumulado, especialidad y cadenciaPedaleo del ciclista.
	 * 
	 * @param tipoCiclista
	 * @param contextura
	 * @param tiempoAcumulado
	 * @param especialidad
	 * @param cadenciaPedaleo
	 */
	public CiclistaDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo) {
		super();
		this.tipoCiclista = tipoCiclista;
		this.contextura = contextura;
		this.tiempoAcumulado = tiempoAcumulado;
		this.especialidad = especialidad;
		this.cadenciaPedaleo = cadenciaPedaleo;
	}

	/**
	 * Constructor heredado para incializar atributos de la clase padre.
	 * 
	 * @param nombre
	 * @param identificador
	 * @param aniosExp
	 * @param tipoCiclista
	 * @param contextura
	 * @param tiempoAcumulado
	 * @param especialidad
	 * @param cadenciaPedaleo
	 * @param nacionalidad
	 */
	public CiclistaDTO(String nombre, long identificador, int aniosExp, String tipoCiclista, String contextura,
			double tiempoAcumulado, String especialidad, String cadenciaPedaleo, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.tipoCiclista = tipoCiclista;
		this.contextura = contextura;
		this.tiempoAcumulado = tiempoAcumulado;
		this.especialidad = especialidad;
		this.cadenciaPedaleo = cadenciaPedaleo;
	}

	/**
	 * Contructor heredado con solo los atributos de la superClase.
	 * 
	 * @param nombre
	 * @param identificador
	 * @param aniosExp
	 * @param nacionalidad
	 */
	public CiclistaDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
		// TODO Auto-generated constructor stub
	}

	public String getTipoCiclista() {
		return tipoCiclista;
	}

	public void setTipoCiclista(String tipoCiclista) {
		this.tipoCiclista = tipoCiclista;
	}

	public String getContextura() {
		return contextura;
	}

	public void setContextura(String contextura) {
		this.contextura = contextura;
	}

	public double getTiempoAcumulado() {
		return tiempoAcumulado;
	}

	public void setTiempoAcumulado(double tiempoAcumulado) {
		this.tiempoAcumulado = tiempoAcumulado;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCadenciaPedaleo() {
		return cadenciaPedaleo;
	}

	public void setCadenciaPedaleo(String cadenciaPedaleo) {
		this.cadenciaPedaleo = cadenciaPedaleo;
	}

	@Override
	public String toString() {
		return "Ciclista: \n Tipo de Ciclista." + tipoCiclista + "\n Contextura:" + contextura + "\n Tiempo Acumulado:"
				+ tiempoAcumulado + "\n Especialidad:" + especialidad + "\n Cadencia de Pedaleo:" + cadenciaPedaleo
				+ "\n Nombre:" + getNombre() + "\n Identificador:" + getIdentificador() + "\n Años de Experiencia:"
				+ getAniosExp() + "\n Nacionalidad:" + getNacionalidad() + "\n";
	}

	// Pusismos algo en mi cuaderno que dice "Agg ciclista: Identificador, nombre y
	// tiempo acumulado"

}
