package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.UsuariosDTO;

public class UsuariosDAO implements CRUDOperation{
	private ArrayList<UsuariosDTO> lista;
	
	public UsuariosDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}


	public void leerDesdeSerializado() {
		Object temp = FileHandler.abrirYLeerSerializable("Usuarios.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<UsuariosDTO>) temp;
		}
	}


	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < lista.size(); i++) {
			contenido += lista.get(i).getUsuario() + ";";
			contenido += lista.get(i).getClave() + ";";
			contenido += lista.get(i).getTipoDeUsuario();
			if (i < lista.size() - 1) {
				contenido += "\n";
			}
		}

		FileHandler.abrirYEscribirArchivo("Usuarios.csv", contenido);
	}

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Usuarios.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			UsuariosDTO temp = new UsuariosDTO();
			temp.setUsuario(columnas[0]);
			temp.setClave(columnas[1]);
			temp.setTipoDeUsuario(columnas[2]);
			lista.add(temp);

		}
	}
	
	public void create(Object o) {
		UsuariosDTO nuevo = (UsuariosDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Usuarios.ddd", lista);
	}


	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			lista.remove(index);
			escribirEnArchivo();
			FileHandler.abrirYEscribirSerializado("Usuarios.ddd", lista);
			return true;
		}
	}


	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			UsuariosDTO info = (UsuariosDTO) o;
			lista.get(index).setUsuario(info.getUsuario());
			lista.get(index).setClave(info.getClave());
			lista.get(index).setTipoDeUsuario(info.getTipoDeUsuario());

		}
		FileHandler.abrirYEscribirSerializado("Usuarios.ddd", lista);
		escribirEnArchivo();
		return true;
	}

	@Override
	public String read() {
		String exit = "";
		for (UsuariosDTO c : lista) {
			exit += c.toString() + "\n";
		}

		return exit;
	}

}
