package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;

/**
 * CiclistaDAO Se realizan las operaciones basicas con un ciclista.
 */
public class CiclistaDAO implements CRUDOperation {
	private ArrayList<CiclistaDTO> lista;

	/**
	 * Constructor de la clase CilcistaDAO que inicializa la lista de ciclistas y
	 * utiliza la funcion de leer desde serializado.
	 */
	public CiclistaDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	/**
	 * Lee la lista de ciclistas mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("CiclistaSerializado.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<CiclistaDTO>) temp;
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
			contenido += lista.get(i).getCadenciaPedaleo() + ";";
			contenido += lista.get(i).getContextura() + ";";
			contenido += lista.get(i).getEspecialidad() + ";";
			contenido += lista.get(i).getIdentificador() + ";";
			contenido += lista.get(i).getNacionalidad() + ";";
			contenido += lista.get(i).getTiempoAcumulado() + ";";
			contenido += lista.get(i).getTipoCiclista();

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Ciclista.csv", contenido);
	}

	/**
	 * Lee la lista de ciclista desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Ciclista.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			CiclistaDTO temp = new CiclistaDTO();
			temp.setNombre(columnas[0]);
			temp.setAniosExp(Integer.parseInt(columnas[1]));
			temp.setCadenciaPedaleo(columnas[2]);
			temp.setContextura(columnas[3]);
			temp.setEspecialidad(columnas[4]);
			temp.setIdentificador(Long.parseLong(columnas[5]));
			temp.setNacionalidad(columnas[6]);
			temp.setTiempoAcumulado(Double.parseDouble(columnas[7]));
			temp.setTipoCiclista(columnas[8]);

			lista.add(temp);

		}
	}

	/**
	 * Este metodo agrega un CiclistaDTO a la lista de ciclistas en el DAO y escribe
	 * los cambios en un archivo.
	 */

	public void create(Object o) {
		CiclistaDTO nuevo = (CiclistaDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("CiclistaSerializado.ddd", lista);

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
			FileHandler.abrirYEscribirSerializado("CiclistaSerializado.ddd", lista);
			return true;
		}
	}

	/**
	 * Este metodo actualiza un ciclista de la lista en la posicion especificada por
	 * index con los atributos de otro objeto CiclistaDTO. Luego, guarda los datos
	 * en el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			CiclistaDTO info = (CiclistaDTO) o;
			lista.get(index).setNombre(info.getNombre());
			lista.get(index).setAniosExp(info.getAniosExp());
			lista.get(index).setCadenciaPedaleo(info.getCadenciaPedaleo());
			lista.get(index).setContextura(info.getContextura());
			lista.get(index).setEspecialidad(info.getEspecialidad());
			lista.get(index).setIdentificador(info.getIdentificador());
			lista.get(index).setNacionalidad(info.getNacionalidad());
			lista.get(index).setTiempoAcumulado(info.getTiempoAcumulado());
			lista.get(index).setTipoCiclista(info.getTipoCiclista());

		}
		FileHandler.abrirYEscribirSerializado("CiclistaSerializado.ddd", lista);
		escribirEnArchivo();
		return true;
	}

	/**
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * ciclistas almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (CiclistaDTO c : lista) {
			exit += c.toString() + "\n";
		}

		return exit;
	}

	/**
	 * Se obtiene la lista de CiclistaDTO
	 * 
	 * @return lista
	 */

	public ArrayList<CiclistaDTO> getLista() {
		return lista;
	}

}