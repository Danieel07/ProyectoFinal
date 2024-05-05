package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase UsuarioDTO representa los usuarios del aplicativo.Contiene la
 * informacion sobre el id, el usuario, la clave, el nombre, el tipo de usuario
 * y el correo.
 */
public class UsuarioDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */

	private static final long serialVersionUID = -5613244232298423060L;

	/**
	 * Contiene los atributos del usuario.
	 */
	private int id = 0;
	private String usuario;
	private String clave;
	private String tipoDeUsuario;
	private String correo;

	/**
	 * Constructor por defecto de la clase UsuarioDTO.
	 */

	public UsuarioDTO() {
	}

	/**
	 * Constructor por defecto que inicializa el usuario, clave, tipoDeUsuario,
	 * correo e id del usuario.
	 * 
	 * @param tipoCiclista
	 * @param contextura
	 * @param tiempoAcumulado
	 * @param especialidad
	 * @param cadenciaPedaleo
	 */

	public UsuarioDTO(String usuario, String clave, String tipoDeUsuario, String correo, int id) {
		this.usuario = usuario;
		this.clave = clave;
		this.tipoDeUsuario = tipoDeUsuario;
		this.correo = correo;
		this.id = id;
	}

	/**
	 * Obtiene el id del usuario.
	 * 
	 * @return id el id del usuario.
	 */

	public int getId() {
		return id;
	}

	/**
	 * Establece el id del usuario.
	 * 
	 * @param id el nuevo id del usuario.
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el usuario.
	 * 
	 * @return usuario el usuario.
	 */

	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece el usuario.
	 * 
	 * @param usuario el nuevo usuario.
	 */

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene la clave.
	 * 
	 * @return clave la clave.
	 */

	public String getClave() {
		return clave;
	}

	/**
	 * Establece la clave.
	 * 
	 * @param clave la nueva clave.
	 */

	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Obtiene el tipo de usuario.
	 * 
	 * @return tipoDeUsuario el tipo de usuario.
	 */

	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	/**
	 * Establece el tipo de usuario.
	 * 
	 * @param tipoDeUsuario el nuevo tipo de usuario.
	 */

	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	/**
	 * Obtiene el correo.
	 * 
	 * @return correo el correo.
	 */

	public String getCorreo() {
		return correo;
	}

	/**
	 * Establece el correo.
	 * 
	 * @param correo el nuevo correo.
	 */

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Devuelve una representacion en cadena del usuario,el id, la clave, el tipo de
	 * usuario y el correo.
	 * 
	 * @return Una cadena que representa el usuario.
	 */

	@Override
	public String toString() {
		return "Usuario: \n id:" + id + "\n Usuario:" + usuario + "\n Clave:" + clave + "\n Tipo de usuario:"
				+ tipoDeUsuario + "\n Correo:" + correo + "\n";
	}

}
