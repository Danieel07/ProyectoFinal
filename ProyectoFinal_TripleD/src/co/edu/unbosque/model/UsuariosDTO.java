package co.edu.unbosque.model;

public class UsuariosDTO {
	private String usuario;
	private String clave;
	private String tipoDeUsuario;
	
	public UsuariosDTO() {
	}
	
	public UsuariosDTO(String usuario, String clave, String tipoDeUsuario) {
		this.usuario = usuario;
		this.clave = clave;
		this.tipoDeUsuario = tipoDeUsuario;
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
	
}
