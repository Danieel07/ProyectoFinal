package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.DirectorDeportivoDTO;

/**
 * DirectorDeportivoDAO Se realizan las operaciones basicas con un director
 * deportivo.
 */

public class DirectorDeportivoDAO implements CRUDOperation {
	private ArrayList<DirectorDeportivoDTO> lista;

	/**
	 * Constructor de la clase DirectorDeportivoDAO que inicializa la lista y activa
	 * la funcion leerDesdeSerializado.
	 */

	public DirectorDeportivoDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	/**
	 * Lee la lista de ciclistas mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("DirectorDeportivoSerializado.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<DirectorDeportivoDTO>) temp;
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
			contenido += lista.get(i).getIdentificador() + ";";
			contenido += lista.get(i).getAniosExp() + ";";
			contenido += lista.get(i).getNacionalidad() + ";";
			contenido += lista.get(i).getLista();

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("DirectorDeportivo.csv", contenido);
	}

	/**
	 * Lee la lista de Directores deportivos desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("DirectorDeportivo.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			DirectorDeportivoDTO temp = new DirectorDeportivoDTO();
			temp.setNombre(columnas[0]);
			temp.setIdentificador(Long.parseLong(columnas[1]));
			temp.setAniosExp(Integer.parseInt(columnas[2]));
			temp.setNacionalidad(columnas[3]);
			String[] ciclistas = columnas[4].split(",");
			ArrayList<CiclistaDTO> listaCiclistas = new ArrayList<>();
			for (String ciclistaIdStr : ciclistas) {
				CiclistaDTO ciclista = new CiclistaDTO();
				ciclista.setIdentificador(Long.parseLong(ciclistaIdStr));
				listaCiclistas.add(ciclista);
			}
			temp.setLista(listaCiclistas);

			lista.add(temp);

		}
	}

	/**
	 * Este metodo agrega un DirectorDeportivoDTO a la lista de directores
	 * deportivos en el DAO y escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		DirectorDeportivoDTO nuevo = (DirectorDeportivoDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("DirectorDeportivoSerializado.ddd", lista);
	}

	/**
	 * Este metodo elimina un director deportivo de la lista.
	 * 
	 * @param index
	 * 
	 * @return true si el director deportivo se elimino correctamente, false si la
	 *         posicion no existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			lista.remove(index);
			escribirEnArchivo();
			FileHandler.abrirYEscribirSerializado("DirectorDeportivoSerializado.ddd", lista);
			return true;
		}
	}

	/**
	 * Este metodo actualiza un director deportivo de la lista en la posicion
	 * especificada por index con los atributos de otro objeto DirectorDeportivoDTO.
	 * Luego, guarda los datos en el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			CiclistaDTO info = (CiclistaDTO) o;
			lista.get(index).setNombre(info.getNombre());
			lista.get(index).setIdentificador(info.getIdentificador());
			lista.get(index).setAniosExp(info.getAniosExp());
			lista.get(index).setNacionalidad(info.getNacionalidad());

		}
		FileHandler.abrirYEscribirSerializado("CiclistaSerializado.ddd", lista);
		escribirEnArchivo();
		return true;
	}

	/**
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * directores deportivos almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (DirectorDeportivoDTO d : lista) {
			exit += d.toString() + "\n";
		}

		return exit;
	}

}
