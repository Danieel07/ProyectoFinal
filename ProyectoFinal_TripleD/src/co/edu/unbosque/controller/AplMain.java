/**
 * Este paquete contiene las clases llamadas AplMain y Controller.
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.view.PanelPrincipal;

/**
 * AplMain es la clase principal que inicia la ejecucion del programa.
 */
public class AplMain {
	/**
	 * el metodo main es el punto de entrada de la aplicacion.
	 * 
	 * args son los argumentos de la linea de comando.
	 */
	public static void main(String[] args) {
		Controller con = new Controller();
		PanelPrincipal panel = new PanelPrincipal();
		//panel.setVisible(true);
		con.run();
	}

}
