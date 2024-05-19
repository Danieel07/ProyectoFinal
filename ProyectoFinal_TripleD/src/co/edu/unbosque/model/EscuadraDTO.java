package co.edu.unbosque.model;

public class EscuadraDTO {
	private String nombre;
	private String nacionalidad;
	private String ciclista1;
	private String ciclista2;
	private String ciclista3;
	private String ciclista4;
	private String ciclista5;
	private String ciclista6;
	private String Masajista;
	
	public EscuadraDTO() {
	}
	public EscuadraDTO(String nombre, String nacionalidad, String ciclista1, String ciclista2, String ciclista3,
			String ciclista4, String ciclista5, String ciclista6, String masajista) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.ciclista1 = ciclista1;
		this.ciclista2 = ciclista2;
		this.ciclista3 = ciclista3;
		this.ciclista4 = ciclista4;
		this.ciclista5 = ciclista5;
		this.ciclista6 = ciclista6;
		Masajista = masajista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getCiclista1() {
		return ciclista1;
	}
	public void setCiclista1(String ciclista1) {
		this.ciclista1 = ciclista1;
	}
	public String getCiclista2() {
		return ciclista2;
	}
	public void setCiclista2(String ciclista2) {
		this.ciclista2 = ciclista2;
	}
	public String getCiclista3() {
		return ciclista3;
	}
	public void setCiclista3(String ciclista3) {
		this.ciclista3 = ciclista3;
	}
	public String getCiclista4() {
		return ciclista4;
	}
	public void setCiclista4(String ciclista4) {
		this.ciclista4 = ciclista4;
	}
	public String getCiclista5() {
		return ciclista5;
	}
	public void setCiclista5(String ciclista5) {
		this.ciclista5 = ciclista5;
	}
	public String getCiclista6() {
		return ciclista6;
	}
	public void setCiclista6(String ciclista6) {
		this.ciclista6 = ciclista6;
	}
	public String getMasajista() {
		return Masajista;
	}
	public void setMasajista(String masajista) {
		Masajista = masajista;
	}
	
	
}
