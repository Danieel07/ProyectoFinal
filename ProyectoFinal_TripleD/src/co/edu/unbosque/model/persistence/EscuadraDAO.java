package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.EscuadraDTO;

public class EscuadraDAO implements CRUDOperation {
	private ArrayList<EscuadraDTO> lista;

	/**
	 * Constructor de la clase EscuadrasDAO que inicializa la lista de Escuadras y
	 * utiliza la funcion de leer desde serializado.
	 */
	public EscuadraDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	/**
	 * Lee la lista de Escuadras mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("EscuadraSerealizado.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<EscuadraDTO>) temp;
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
			contenido += lista.get(i).getNacionalidad() + ";";
			contenido += lista.get(i).getCiclista1() + ";";
			contenido += lista.get(i).getCiclista2() + ";";
			contenido += lista.get(i).getCiclista3() + ";";
			contenido += lista.get(i).getCiclista4() + ";";
			contenido += lista.get(i).getCiclista5() + ";";
			contenido += lista.get(i).getCiclista6() + ";";
			contenido += lista.get(i).getMasajista() + ";";
			contenido += lista.get(i).getDirectorTecnico();

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Escuadras.csv", contenido);
	}

	/**
	 * Lee la lista de Escuadras desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Escuadras.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			EscuadraDTO temp = new EscuadraDTO();
			temp.setNombre(columnas[0]);
			temp.setNacionalidad(columnas[1]);
			temp.setCiclista1(columnas[2]);
			temp.setCiclista2(columnas[3]);
			temp.setCiclista3(columnas[4]);
			temp.setCiclista4(columnas[5]);
			temp.setCiclista5(columnas[6]);
			temp.setCiclista6(columnas[7]);
			temp.setMasajista(columnas[8]);
			temp.setDirectorTecnico(columnas[9]);
			lista.add(temp);

		}
	}

	/**
	 * Este metodo agrega un MasajistaDTO a la lista de masajistas en el DAO y
	 * escribe los cambios en un archivo.
	 */

	public void create(Object o) {
		EscuadraDTO nuevo = (EscuadraDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("EscuadraSerealizado.ddd", lista);

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
			FileHandler.abrirYEscribirSerializado("EscuadraSerealizado.ddd", lista);
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
			EscuadraDTO info = (EscuadraDTO) o;
			lista.get(index).setNombre(info.getNombre());
			lista.get(index).setNacionalidad(info.getNacionalidad());
			lista.get(index).setCiclista1(info.getCiclista1());
			lista.get(index).setCiclista2(info.getCiclista2());
			lista.get(index).setCiclista3(info.getCiclista3());
			lista.get(index).setCiclista4(info.getCiclista4());
			lista.get(index).setCiclista5(info.getCiclista5());
			lista.get(index).setCiclista6(info.getCiclista6());
			lista.get(index).setMasajista(info.getMasajista());
			lista.get(index).setDirectorTecnico(info.getDirectorTecnico());
		}
		FileHandler.abrirYEscribirSerializado("EscuadraSerealizado.ddd", lista);
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
		for (EscuadraDTO m : lista) {
			exit += m.toString() + "\n";
		}

		return exit;
	}

	/**
	 * Se obtiene la lista de MasajistaDTO
	 * 
	 * @return lista
	 */

	public ArrayList<EscuadraDTO> getLista() {
		return lista;
	}


}
