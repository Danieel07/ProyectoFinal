package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaClasicomanoDTO;

public class CiclistaClasicomanoDAO implements CRUDOperation {
	private ArrayList<CiclistaClasicomanoDTO> lista;

	public CiclistaClasicomanoDAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("ClasicomanoSerializado.ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<CiclistaClasicomanoDTO>) temp;
		}
	}

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
			contenido += lista.get(i).getTipoCiclista() + ";";
			contenido += lista.get(i).getNumeroClasicosGanados();

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Clasicomano.csv", contenido);
	}

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Clasicomano.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			CiclistaClasicomanoDTO temp = new CiclistaClasicomanoDTO();
			temp.setNombre(columnas[0]);
			temp.setAniosExp(Integer.parseInt(columnas[1]));
			temp.setCadenciaPedaleo(columnas[2]);
			temp.setContextura(columnas[3]);
			temp.setEspecialidad(columnas[4]);
			temp.setIdentificador(Long.parseLong(columnas[5]));
			temp.setNacionalidad(columnas[6]);
			temp.setTiempoAcumulado(Double.parseDouble(columnas[7]));
			temp.setTipoCiclista(columnas[8]);
			temp.setNumeroClasicosGanados(Integer.parseInt(columnas[9]));

			lista.add(temp);

		}
	}

	public void create(Object o) {
		CiclistaClasicomanoDTO nuevo = (CiclistaClasicomanoDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("ClasicomanoSerializado.ddd", lista);

	}

	public boolean delete(int index) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			lista.remove(index);
			escribirEnArchivo();
			FileHandler.abrirYEscribirSerializado("ClasicomanoSerializado.ddd", lista);
			return true;
		}
	}

	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			CiclistaClasicomanoDTO info = (CiclistaClasicomanoDTO) o;
			lista.get(index).setNombre(info.getNombre());
			lista.get(index).setAniosExp(info.getAniosExp());
			lista.get(index).setCadenciaPedaleo(info.getCadenciaPedaleo());
			lista.get(index).setContextura(info.getContextura());
			lista.get(index).setEspecialidad(info.getEspecialidad());
			lista.get(index).setIdentificador(info.getIdentificador());
			lista.get(index).setNacionalidad(info.getNacionalidad());
			lista.get(index).setTiempoAcumulado(info.getTiempoAcumulado());
			lista.get(index).setTipoCiclista(info.getTipoCiclista());
			lista.get(index).setNumeroClasicosGanados(info.getNumeroClasicosGanados());

		}
		FileHandler.abrirYEscribirSerializado("ClasicomanoSerializado.ddd", lista);
		escribirEnArchivo();
		return true;
	}

	public String read() {
		String exit = "";
		for (CiclistaClasicomanoDTO c : lista) {
			exit += c.toString() + "\n";
		}

		return exit;
	}

	public ArrayList<CiclistaClasicomanoDTO> getLista() {
		return lista;
	}

}
