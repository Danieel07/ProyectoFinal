package co.edu.unbosque.model;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	
	private static final long serialVersionUID = -5613244232298423060L;
	
	
	private int id = 0;
	private String usuario;
	private String clave;
	private String tipoDeUsuario;
	private String correo;
	
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id) {
		this.usuario = usuario;
		this.clave = clave;
		this.tipoDeUsuario = tipoDeUsuario;
		this.correo = correo;
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
