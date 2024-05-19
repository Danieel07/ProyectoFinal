package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.MasajistaDTO;

/**
 * MasajistaDAO Se realiza las operaciones basicas con un masajista.
 */
public class MasajistaDAO implements CRUDOperation {
	private ArrayList<MasajistaDTO> lista;

	/**
	 * Constructor de la clase MasajistaDAO que inicializa la lista de masajistas y
	 * utiliza la funcion de leer desde serializado.
	 */
	public MasajistaDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	/**
	 * Lee la lista de masajistas mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("MasajistaSerializado.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<MasajistaDTO>) temp;
		}
	}

	/**
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < lista.size(); i++) {
			contenido += lista.get(i).getNombre() + ";";
			contenido += lista.get(i).getAniosExp() + ";";
			contenido += lista.get(i).getIdentificador() + ";";
			contenido += lista.get(i).getNacionalidad() + ";";
			contenido += lista.get(i).getUsuario()+ ";";
			contenido += lista.get(i).getClave()+ ";";
			contenido += lista.get(i).getCorreo()+ ";";
			contenido += lista.get(i).getTipoDeUsuario()+ ";";
			contenido += lista.get(i).getId();

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Masajista.csv", contenido);
	}

	/**
	 * Lee la lista de masajista desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Masajista.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			MasajistaDTO temp = new MasajistaDTO();
			temp.setNombre(columnas[0]);
			temp.setAniosExp(Integer.parseInt(columnas[1]));
			temp.setIdentificador(Long.parseLong(columnas[2]));
			temp.setNacionalidad(columnas[3]);
			temp.setLlenoDatos(columnas[4]);
			temp.setUsuario(columnas[5]);
			temp.setClave(columnas[6]);
			temp.setCorreo(columnas[7]);
			temp.setTipoDeUsuario(columnas[8]);
			temp.setId(Integer.parseInt(columnas[9]));

			lista.add(temp);

		}
	}

	/**
	 * Este metodo agrega un MasajistaDTO a la lista de masajistas en el DAO y
	 * escribe los cambios en un archivo.
	 */

	public void create(Object o) {
		MasajistaDTO nuevo = (MasajistaDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("MasajistaSerializado.ddd", lista);

	}

	/**
	 * Este metodo elimina un ciclista de la lista.
	 * 
	 * @param index
	 * 
	 * @return true si el ciclista se elimino correctamente, false si la posicion no
	 *         existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			lista.remove(index);
			escribirEnArchivo();
			FileHandler.abrirYEscribirSerializado("MasajistaSerializado.ddd", lista);
			return true;
		}
	}

	/**
	 * Este metodo actualiza un masajista de la lista en la posicion especificada
	 * por index con los atributos de otro objeto MasajistaDTO. Luego, guarda los
	 * datos en el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			MasajistaDTO info = (MasajistaDTO) o;
			lista.get(index).setNombre(info.getNombre());
			lista.get(index).setAniosExp(info.getAniosExp());
			lista.get(index).setIdentificador(info.getIdentificador());
			lista.get(index).setNacionalidad(info.getNacionalidad());

		}
		FileHandler.abrirYEscribirSerializado("MasajistaSerializado.ddd", lista);
		escribirEnArchivo();
		return true;
	}

	/**
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * masajistas almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (MasajistaDTO m : lista) {
			exit += m.toString() + "\n";
		}

		return exit;
	}

	/**
	 * Se obtiene la lista de MasajistaDTO
	 * 
	 * @return lista
	 */

	public ArrayList<MasajistaDTO> getLista() {
		return lista;
	}

}
