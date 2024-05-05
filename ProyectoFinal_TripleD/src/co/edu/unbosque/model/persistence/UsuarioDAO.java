package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * UsuarioDAO Se realizan las operaciones basicas con un usuario.
 */

public class UsuarioDAO implements CRUDOperation {
	private ArrayList<UsuarioDTO> lista;

	/**
	 * Constructor de la clase UsuarioDAO que inicializa la lista y activa la
	 * funcion leerDesdeSerializado.
	 */

	public UsuarioDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	/**
	 * Lee la lista de usuarios mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {
		Object temp = FileHandler.abrirYLeerSerializable("UsuarioSerializido.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<UsuarioDTO>) temp;
		}
	}

	/**
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < lista.size(); i++) {
			contenido += lista.get(i).getUsuario() + ";";
			contenido += lista.get(i).getClave() + ";";
			contenido += lista.get(i).getTipoDeUsuario() + ";";
			contenido += lista.get(i).getCorreo() + ";";
			contenido += lista.get(i).getId() + ";";

			if (i < lista.size() - 1) {
				contenido += "\n";
			}
		}

		FileHandler.abrirYEscribirArchivo("Usuarios.csv", contenido);
	}

	/**
	 * Lee la lista de usuarios desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Usuarios.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			UsuarioDTO temp = new UsuarioDTO();
			temp.setUsuario(columnas[0]);
			temp.setClave(columnas[1]);
			temp.setTipoDeUsuario(columnas[2]);
			temp.setCorreo(columnas[3]);
			temp.setId(Integer.parseInt(columnas[4]));
			lista.add(temp);

		}
	}

	/**
	 * Este metodo agrega un UsuarioDTO a la lista de usuarios en el DAO y escribe
	 * los cambios en un archivo.
	 */

	public void create(Object o) {
		UsuarioDTO nuevo = (UsuarioDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("UsuarioSerializido.ddd", lista);
	}

	/**
	 * Este metodo elimina un usuario de la lista.
	 * 
	 * @param index
	 * 
	 * @return true si el usuario se elimino correctamente, false si la posicion no
	 *         existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			lista.remove(index);
			escribirEnArchivo();
			FileHandler.abrirYEscribirSerializado("UsuarioSerializido.ddd", lista);
			return true;
		}
	}

	/**
	 * Este metodo actualiza un usuario de la lista en la posicion especificada por
	 * index con los atributos de otro objeto UsuarioDTO. Luego, guarda los datos en
	 * el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {

			UsuarioDTO info = (UsuarioDTO) o;
			lista.get(index).setUsuario(info.getUsuario());
			lista.get(index).setClave(info.getClave());
			lista.get(index).setTipoDeUsuario(info.getTipoDeUsuario());
			lista.get(index).setCorreo(info.getCorreo());
			lista.get(index).setId(info.getId());

		}
		FileHandler.abrirYEscribirSerializado("UsuarioSerializido.ddd", lista);
		escribirEnArchivo();
		return true;
	}

	/**
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * usuarios almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (UsuarioDTO c : lista) {
			exit += c.toString() + "\n";
		}

		return exit;
	}

}
