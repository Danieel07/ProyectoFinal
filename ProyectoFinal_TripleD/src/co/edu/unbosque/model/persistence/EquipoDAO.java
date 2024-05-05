package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.EquipoDTO;

public class EquipoDAO implements CRUDOperation {
	private ArrayList<EquipoDTO> lista;

	public EquipoDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	/**
	 * Lee la lista de equipos mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("DirectorDeportivoSerializado.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<EquipoDTO>) temp;
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
			contenido += lista.get(i).getPais() + ";";
			contenido += lista.get(i).getSumaTiempo() + ";";

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Equipo.csv", contenido);
	}

	/**
	 * Lee la lista de equipos desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Equipo.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			EquipoDTO temp = new EquipoDTO();
			temp.setNombre(columnas[0]);
			temp.setPais(columnas[1]);
			temp.setSumaTiempo(Double.parseDouble(columnas[2]));

			lista.add(temp);

		}
	}

	/**
	 * Este metodo agrega un EquipoDTO a la lista de equipos en el DAO y escribe los
	 * cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		EquipoDTO nuevo = (EquipoDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("EquipoSerializado.ddd", lista);
	}

	/**
	 * Este metodo elimina un equipo de la lista.
	 * 
	 * @param index
	 * 
	 * @return true si el equipo se elimino correctamente, false si la posicion no
	 *         existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			lista.remove(index);
			escribirEnArchivo();
			FileHandler.abrirYEscribirSerializado("EquipoSerializado.ddd", lista);
			return true;
		}
	}

	/**
	 * Este metodo actualiza un equipo de la lista en la posicion especificada por
	 * index con los atributos de otro objeto EquipoDTO. Luego, guarda los datos en
	 * el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			EquipoDTO info = (EquipoDTO) o;
			lista.get(index).setNombre(info.getNombre());
			lista.get(index).setPais(info.getPais());
			lista.get(index).setSumaTiempo(info.getSumaTiempo());

		}
		FileHandler.abrirYEscribirSerializado("EquipoSerializado.ddd", lista);
		escribirEnArchivo();
		return true;
	}

	/**
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * equipos almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (EquipoDTO e : lista) {
			exit += e.toString() + "\n";
		}

		return exit;
	}

}
