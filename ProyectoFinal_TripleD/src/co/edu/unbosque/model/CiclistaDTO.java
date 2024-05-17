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
	private String atributoExtra1;
	private String atributoExtra2;
	private String atributoExtra3;
	private int llenoLosDatos;

	
	public CiclistaDTO() {
	}


	public CiclistaDTO(String tipoCiclista, String contextura, double tiempoAcumulado, String especialidad,
			String cadenciaPedaleo, String atributoExtra1, String atributoExtra2, String atributoExtra3,int llenoLosDatos) {
		super();
		this.tipoCiclista = tipoCiclista;
		this.contextura = contextura;
		this.tiempoAcumulado = tiempoAcumulado;
		this.especialidad = especialidad;
		this.cadenciaPedaleo = cadenciaPedaleo;
		this.atributoExtra1 = atributoExtra1;
		this.atributoExtra2 = atributoExtra2;
		this.atributoExtra3 = atributoExtra3;
		this.llenoLosDatos =  llenoLosDatos;
	}


	public CiclistaDTO(String nombre, long identificador, int aniosExp, String nacionalidad, String tipoCiclista,
			String contextura, double tiempoAcumulado, String especialidad, String cadenciaPedaleo,
			String atributoExtra1, String atributoExtra2, String atributoExtra3, int llenoLosDatos) {
		super(nombre, identificador, aniosExp, nacionalidad);
		this.tipoCiclista = tipoCiclista;
		this.contextura = contextura;
		this.tiempoAcumulado = tiempoAcumulado;
		this.especialidad = especialidad;
		this.cadenciaPedaleo = cadenciaPedaleo;
		this.atributoExtra1 = atributoExtra1;
		this.atributoExtra2 = atributoExtra2;
		this.atributoExtra3 = atributoExtra3;
		this.llenoLosDatos = llenoLosDatos;
	}


	public CiclistaDTO(String nombre, long identificador, int aniosExp, String nacionalidad) {
		super(nombre, identificador, aniosExp, nacionalidad);
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


	public String getAtributoExtra1() {
		return atributoExtra1;
	}


	public void setAtributoExtra1(String atributoExtra1) {
		this.atributoExtra1 = atributoExtra1;
	}


	public String getAtributoExtra2() {
		return atributoExtra2;
	}


	public void setAtributoExtra2(String atributoExtra2) {
		this.atributoExtra2 = atributoExtra2;
	}


	public String getAtributoExtra3() {
		return atributoExtra3;
	}


	public void setAtributoExtra3(String atributoExtra3) {
		this.atributoExtra3 = atributoExtra3;
	}


	public int getLlenoLosDatos() {
		return llenoLosDatos;
	}


	public void setLlenoLosDatos(int llenoLosDatos) {
		this.llenoLosDatos = llenoLosDatos;
	}
	
	
	

}
