package co.edu.unbosque.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.DirectorDeportivoDTO;
import co.edu.unbosque.model.EscuadraDTO;
import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.ModelFacade;
import co.edu.unbosque.view.DatosPersonalesView;
import co.edu.unbosque.view.ViewFacade;

/**
 * La clase Controller es el controlador principal del aplicativo.
 */
public class Controller implements ActionListener {

	// Enviar Gmail
	private static String emailFrom = "isuciconfirmation@gmail.com";
	private static String passwordFrom = "klxzzxrbhvhxoevw";
	private String emailTo = "";
	private String subject = "Confirmación De Registro En El Sistema ISUCI";
	private String content = "";

	private Properties mProperties;
	private Session mSession;
	private MimeMessage mCorreo;

	// Facades
	private ModelFacade modelFacade;
	private ViewFacade viewFacade;
	private String usuario;
	private String tipoUsuario;
	private String correo;
	private String clave;
	private int id;
	private String rangoUsuario;
	private String usuarioLogin;
	private int indexValue;
	private DefaultTableModel model;
	private ArrayList<String> nombreCiclista = new ArrayList<>();
	private DefaultTableModel modelEscuadra;

	/**
	 * El constructor de la clase Controller inicializa los objetos y asigna oyentes
	 * a los elementos de la interfaz grafica.
	 */

	public Controller() {
		viewFacade = new ViewFacade();
		modelFacade = new ModelFacade();
		mProperties = new Properties();
		listeners();
	}

	/*
	 * El metodo run muestra la ventana principal de la aplicacion.
	 */

	public void run() {
		viewFacade.getLoginView().setVisible(true);
	}

	/**
	 * Asigna oyentes a los elementos de la interfaz grafica.
	 */

	public void listeners() {
		// Login View
		viewFacade.getLoginView().btnRegistro.addActionListener(this);
		viewFacade.getLoginView().btnRegistro.setActionCommand("AbrirViewRegistro");
		viewFacade.getLoginView().btnInicioSesion.addActionListener(this);
		viewFacade.getLoginView().btnInicioSesion.setActionCommand("Login");

		// Registro View
		viewFacade.getRegistroView().btnCrearUsuario.addActionListener(this);
		viewFacade.getRegistroView().btnCrearUsuario.setActionCommand("SeleccionarTipoUsuario");
		viewFacade.getRegistroView().btnRegresar.addActionListener(this);
		viewFacade.getRegistroView().btnRegresar.setActionCommand("RegresarRegistro");
		viewFacade.getRegistroView().btnSeleccionarTipoDeCiclista.addActionListener(this);
		viewFacade.getRegistroView().btnSeleccionarTipoDeCiclista.setActionCommand("SeleccionarTipoCiclista");
		viewFacade.getRegistroView().btnGuardarDatos.addActionListener(this);
		viewFacade.getRegistroView().btnGuardarDatos.setActionCommand("GuardarDatosPersonales");

		// PanelPrincipal
		viewFacade.getPanelPrincipal().btnRegresar.addActionListener(this);
		viewFacade.getPanelPrincipal().btnRegresar.setActionCommand("Regresar");
		viewFacade.getPanelPrincipal().btnLlenarDatos.addActionListener(this);
		viewFacade.getPanelPrincipal().btnLlenarDatos.setActionCommand("DatosPersonales");
		viewFacade.getPanelPrincipal().btnCrearEscuadra.addActionListener(this);
		viewFacade.getPanelPrincipal().btnCrearEscuadra.setActionCommand("AbrirCrearEscuadra");
		viewFacade.getPanelPrincipal().btnEscuadra.addActionListener(this);
		viewFacade.getPanelPrincipal().btnEscuadra.setActionCommand("MiEscuadra");

		// DatosPersonales
		viewFacade.getDatosPersonalesView().btnRegresarDatos.addActionListener(this);
		viewFacade.getDatosPersonalesView().btnRegresarDatos.setActionCommand("RegresarDatosPersonales");
		viewFacade.getDatosPersonalesView().btnSeleccionarTipoDeCiclista.addActionListener(this);
		viewFacade.getDatosPersonalesView().btnSeleccionarTipoDeCiclista.setActionCommand("TipoCiclista");

		// CrearEscuadra
		viewFacade.getCrearEscuadraView().btnRegresarPanelPrincipal.addActionListener(this);
		viewFacade.getCrearEscuadraView().btnRegresarPanelPrincipal.setActionCommand("CrearEscuadraRegreso");
		viewFacade.getCrearEscuadraView().btnSelecionar.addActionListener(this);
		viewFacade.getCrearEscuadraView().btnSelecionar.setActionCommand("SeleccionarCiclista");
		viewFacade.getCrearEscuadraView().btnAgregar.addActionListener(this);
		viewFacade.getCrearEscuadraView().btnAgregar.setActionCommand("AgregarCiclista");
		viewFacade.getCrearEscuadraView().btnEliminar.addActionListener(this);
		viewFacade.getCrearEscuadraView().btnEliminar.setActionCommand("EliminarCiclista");
		viewFacade.getCrearEscuadraView().btnCrear.addActionListener(this);
		viewFacade.getCrearEscuadraView().btnCrear.setActionCommand("CrearEscuadra");
		
		//EscuadreView
		viewFacade.getEscuadraView().btnRegresar.addActionListener(this);
		viewFacade.getEscuadraView().btnRegresar.setActionCommand("RegresarEscuadra");
	}

	/**
	 * Este metodo contiene todas las acciones que se ejecutaran en el programa.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);

		switch (actionCommand) {

		case "AbrirViewRegistro": {
			viewFacade.getLoginView().setVisible(false);
			viewFacade.getRegistroView().setVisible(true);

			break;
		}

		case "SeleccionarTipoUsuario": {

			tipoUsuario = (String) viewFacade.getRegistroView().listTipoDeUsuario.getSelectedValue();

			switch (tipoUsuario) {
			case "Administrador": {
				viewFacade.getRegistroView().panel2.setVisible(true);
				viewFacade.getRegistroView().lblTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().listTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().lblEspecialidad.setVisible(false);
				viewFacade.getRegistroView().txtEspecialidad.setVisible(false);
				viewFacade.getRegistroView().btnSeleccionarTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().lblContextura.setVisible(false);
				viewFacade.getRegistroView().txtContextura.setVisible(false);
				viewFacade.getRegistroView().lblCadenciaDePedaleo.setVisible(false);
				viewFacade.getRegistroView().txtCadenciaPedaleo.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra3.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra3.setVisible(false);

				break;
			}
			case "Director Deportivo": {
				viewFacade.getRegistroView().panel2.setVisible(true);
				viewFacade.getRegistroView().lblTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().listTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().lblEspecialidad.setVisible(false);
				viewFacade.getRegistroView().txtEspecialidad.setVisible(false);
				viewFacade.getRegistroView().btnSeleccionarTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().lblContextura.setVisible(false);
				viewFacade.getRegistroView().txtContextura.setVisible(false);
				viewFacade.getRegistroView().lblCadenciaDePedaleo.setVisible(false);
				viewFacade.getRegistroView().txtCadenciaPedaleo.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra3.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra3.setVisible(false);

				break;
			}
			case "Masajista": {
				viewFacade.getRegistroView().panel2.setVisible(true);
				viewFacade.getRegistroView().lblTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().listTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().lblEspecialidad.setVisible(false);
				viewFacade.getRegistroView().txtEspecialidad.setVisible(false);
				viewFacade.getRegistroView().btnSeleccionarTipoDeCiclista.setVisible(false);
				viewFacade.getRegistroView().lblContextura.setVisible(false);
				viewFacade.getRegistroView().txtContextura.setVisible(false);
				viewFacade.getRegistroView().lblCadenciaDePedaleo.setVisible(false);
				viewFacade.getRegistroView().txtCadenciaPedaleo.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra3.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra3.setVisible(false);
				break;
			}
			case "Ciclista": {
				viewFacade.getRegistroView().panel2.setVisible(true);
				viewFacade.getRegistroView().lblTipoDeCiclista.setVisible(true);
				viewFacade.getRegistroView().listTipoDeCiclista.setVisible(true);
				viewFacade.getRegistroView().lblEspecialidad.setVisible(true);
				viewFacade.getRegistroView().txtEspecialidad.setVisible(true);
				viewFacade.getRegistroView().btnSeleccionarTipoDeCiclista.setVisible(true);
				viewFacade.getRegistroView().lblContextura.setVisible(true);
				viewFacade.getRegistroView().txtContextura.setVisible(true);
				viewFacade.getRegistroView().lblCadenciaDePedaleo.setVisible(true);
				viewFacade.getRegistroView().txtCadenciaPedaleo.setVisible(true);

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + tipoUsuario);
			}

			break;
		}
		case "Login": {

			System.out.println("Login");
			// Creacion de variables
			usuarioLogin = "";
			String claveLogin = "";

			// Tomar valores de los campos de texto
			usuarioLogin = viewFacade.getLoginView().txtUsuario.getText().toLowerCase();
			claveLogin = viewFacade.getLoginView().txtClave.getText();

			// Validar Que los campos no esten vacios
			if (usuarioLogin.isEmpty() || claveLogin.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Para Iniciar Sesión antes debe digitar sus credenciales");

			} else {
				// Ciclo que Recorre la lista de usuarios
				for (int i = 0; i < modelFacade.getuDAO().getLista().size(); i++) {
					// Valida que los Datos ingresados y de la Base Datos sean congruentes
					if (modelFacade.getuDAO().getLista().get(i).getUsuario().toLowerCase().equals(usuarioLogin)
							&& modelFacade.getuDAO().getLista().get(i).getClave().equals(claveLogin)) {

						viewFacade.getPanelPrincipal().setVisible(true);

						// Oculta el Login y Limpia Los campos
						viewFacade.getLoginView().setVisible(false);
						viewFacade.getLoginView().txtUsuario.setText("");
						viewFacade.getLoginView().txtClave.setText("");
						break;
					}
				}

				// Muestra El Nombre y El rol Del usuario
				viewFacade.getPanelPrincipal().lblBienvenido.setText(usuarioLogin.toUpperCase());

				ArrayList<UsuarioDTO> listaUsuarios = modelFacade.getuDAO().getLista();
				for (UsuarioDTO usuarioDTO : listaUsuarios) {

					if (usuarioDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {

						System.out.println("Entro");
						rangoUsuario = usuarioDTO.getTipoDeUsuario();
						viewFacade.getPanelPrincipal().lblRol.setText(rangoUsuario);

						switch (rangoUsuario) {
						case "Administrador": {
							viewFacade.getPanelPrincipal().btnCrearEscuadra.setVisible(true);
							viewFacade.getPanelPrincipal().btnSimularCarrera.setVisible(true);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setVisible(true);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setBounds(174, 354, 264, 41);
							break;
						}
						case "Director Deportivo": {
							System.out.println("Director Deportivo");
							viewFacade.getPanelPrincipal().btnCrearEscuadra.setVisible(true);
							viewFacade.getPanelPrincipal().btnSimularCarrera.setVisible(true);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setVisible(true);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setBounds(174, 354, 264, 41);

							ArrayList<DirectorDeportivoDTO> listaDirectores = modelFacade.getDdDAO().getList();
							for (DirectorDeportivoDTO directorDeportivoDTO : listaDirectores) {
								if (directorDeportivoDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
									if(directorDeportivoDTO.getNombreEscuadra() == null) {
										viewFacade.getPanelPrincipal().btnCrearEscuadra.setEnabled(true);
										break;
									}else {
										viewFacade.getPanelPrincipal().btnCrearEscuadra.setEnabled(false);
										break;
									}
								} 
							}
							break;
						}
						case "Masajista": {
							viewFacade.getPanelPrincipal().btnCrearEscuadra.setVisible(false);
							viewFacade.getPanelPrincipal().btnSimularCarrera.setVisible(false);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setVisible(false);
							break;
						}
						case "Ciclista": {
							viewFacade.getPanelPrincipal().btnCrearEscuadra.setVisible(false);
							viewFacade.getPanelPrincipal().btnSimularCarrera.setVisible(false);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setBounds(174, 231, 264, 41);
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + rangoUsuario);
						}

						break;
					}
				}
			}

			break;

		}
		case "Regresar": {
			viewFacade.getLoginView().setVisible(true);
			viewFacade.getPanelPrincipal().setVisible(false);
			break;

		}
		case "RegresarRegistro": {
			viewFacade.getLoginView().setVisible(true);
			viewFacade.getRegistroView().setVisible(false);
			viewFacade.getRegistroView().panel2.setVisible(false);
			viewFacade.getRegistroView().txtUsuario.setText("");
			viewFacade.getRegistroView().txtClave.setText("");
			viewFacade.getRegistroView().txtCorreo.setText("");
			viewFacade.getRegistroView().txtNombre.setText("");
			viewFacade.getRegistroView().txtCedula.setText("");
			viewFacade.getRegistroView().txtAnosExperiencia.setText("");
			;
			viewFacade.getRegistroView().txtNacionalidad.setText("");
			viewFacade.getRegistroView().txtContextura.setText("");
			viewFacade.getRegistroView().txtEspecialidad.setText("");
			viewFacade.getRegistroView().txtCadenciaPedaleo.setText("");
			break;

		}
		case "SeleccionarTipoCiclista": {
			String tipoCiclista = (String) viewFacade.getRegistroView().listTipoDeCiclista.getSelectedValue();

			switch (tipoCiclista) {

			case "Escaladores": {
				viewFacade.getRegistroView().lblListaGregario.setVisible(false);
				viewFacade.getRegistroView().listFuncionDeGregario.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra3.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra3.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setText("Aceleración En Subida:");
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(true);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(true);

				viewFacade.getRegistroView().lblAtributoExtra2.setText("grado de rampa soportada:");
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(true);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(true);

				viewFacade.getRegistroView().txtAtributoExtra1.setText("");
				viewFacade.getRegistroView().txtAtributoExtra2.setText("");
				viewFacade.getRegistroView().txtAtributoExtra3.setText("");

				break;
			}
			case "Rodadores": {
				viewFacade.getRegistroView().lblListaGregario.setVisible(false);
				viewFacade.getRegistroView().listFuncionDeGregario.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra3.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra3.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setText("Velocidad Promedio De Pedaleo:");
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(true);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(true);

				viewFacade.getRegistroView().txtAtributoExtra1.setText("");
				viewFacade.getRegistroView().txtAtributoExtra2.setText("");
				viewFacade.getRegistroView().txtAtributoExtra3.setText("");
				break;

			}
			case "Sprinters": {
				viewFacade.getRegistroView().lblListaGregario.setVisible(false);
				viewFacade.getRegistroView().listFuncionDeGregario.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra3.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra3.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setText("Potencia Promedio:");
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(true);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(true);

				viewFacade.getRegistroView().lblAtributoExtra2.setText("Velocidad Promedio:");
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(true);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(true);

				viewFacade.getRegistroView().txtAtributoExtra1.setText("");
				viewFacade.getRegistroView().txtAtributoExtra2.setText("");
				viewFacade.getRegistroView().txtAtributoExtra3.setText("");
				break;

			}
			case "Gregarios": {
				viewFacade.getRegistroView().lblListaGregario.setVisible(false);
				viewFacade.getRegistroView().listFuncionDeGregario.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra3.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra3.setVisible(false);

				viewFacade.getRegistroView().lblListaGregario.setLocation(248, 30);
				viewFacade.getRegistroView().listFuncionDeGregario.setLocation(258, 55);
				viewFacade.getRegistroView().lblListaGregario.setVisible(true);
				viewFacade.getRegistroView().listFuncionDeGregario.setVisible(true);

				viewFacade.getRegistroView().txtAtributoExtra1.setText("");
				viewFacade.getRegistroView().txtAtributoExtra2.setText("");
				viewFacade.getRegistroView().txtAtributoExtra3.setText("");
				break;

			}
			case "Clasicómanos": {
				viewFacade.getRegistroView().lblListaGregario.setVisible(false);
				viewFacade.getRegistroView().listFuncionDeGregario.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setText("Numero De Clasicos Ganados:");
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(true);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(true);

				viewFacade.getRegistroView().txtAtributoExtra1.setText("");
				viewFacade.getRegistroView().txtAtributoExtra2.setText("");
				viewFacade.getRegistroView().txtAtributoExtra3.setText("");
				break;

			}
			case "Contrarrelojista": {
				viewFacade.getRegistroView().lblListaGregario.setVisible(false);
				viewFacade.getRegistroView().listFuncionDeGregario.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(false);
				viewFacade.getRegistroView().lblAtributoExtra2.setVisible(false);
				viewFacade.getRegistroView().txtAtributoExtra2.setVisible(false);

				viewFacade.getRegistroView().lblAtributoExtra1.setText("Velocidad Maxima:");
				viewFacade.getRegistroView().lblAtributoExtra1.setVisible(true);
				viewFacade.getRegistroView().txtAtributoExtra1.setVisible(true);

				viewFacade.getRegistroView().txtAtributoExtra1.setText("");
				viewFacade.getRegistroView().txtAtributoExtra2.setText("");
				viewFacade.getRegistroView().txtAtributoExtra3.setText("");
				break;

			}
			default:
				JOptionPane.showMessageDialog(null, "Algo salio Mal");
			}

			break;
		}
		case "GuardarDatosPersonales": {
			usuario = viewFacade.getRegistroView().txtUsuario.getText();
			clave = viewFacade.getRegistroView().txtClave.getText();
			correo = viewFacade.getRegistroView().txtCorreo.getText();
			String nombre = viewFacade.getRegistroView().txtNombre.getText();
			long cedula = Long.parseLong(viewFacade.getRegistroView().txtCedula.getText());
			int aniosExp = Integer.parseInt(viewFacade.getRegistroView().txtAnosExperiencia.getText());
			String nacionalidad = viewFacade.getRegistroView().txtNacionalidad.getText();
			String contextura = viewFacade.getRegistroView().txtContextura.getText();
			double tiempoAcumylado = 0;
			String especialidad = viewFacade.getRegistroView().txtEspecialidad.getText();
			String cadenciaPedaleo = viewFacade.getRegistroView().txtCadenciaPedaleo.getText();
			int llenoDatos = 1;
			String tipoCiclista = (String) viewFacade.getRegistroView().listTipoDeCiclista.getSelectedValue();
			String atributoExtra1 = "";
			String atributoExtra2 = "";
			String atributoExtra3 = "";

			if (modelFacade.getuDAO().getLista().size() == 0) {
				id = 0;
			} else {
				id = modelFacade.getuDAO().getLista().get(modelFacade.getuDAO().getLista().size() - 1).getId() + 1;
			}

			switch (tipoUsuario) {
			case "Administrador": {
				modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, 0));
				break;
			}
			case "Director Deportivo": {
				modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, id));
				modelFacade.getDdDAO().create(new DirectorDeportivoDTO(usuario.toUpperCase(), clave, tipoUsuario,
						correo, id, nombre, cedula, aniosExp, nacionalidad));
				break;
			}
			case "Masajista": {
				modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, id));
				modelFacade.getmDAO().create(new MasajistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula,
						aniosExp, nacionalidad, "1"));

				break;
			}
			case "Ciclista": {

				modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, id));
				switch (tipoCiclista) {

				case "Escaladores": {
					atributoExtra1 = viewFacade.getRegistroView().txtAtributoExtra1.getText();
					atributoExtra2 = viewFacade.getRegistroView().txtAtributoExtra2.getText();

					modelFacade.getcDAO()
							.create(new CiclistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula, aniosExp,
									nacionalidad, tipoCiclista, contextura, tiempoAcumylado, especialidad,
									cadenciaPedaleo, atributoExtra1, atributoExtra2, atributoExtra3, llenoDatos));
					break;
				}
				case "Rodadores": {
					atributoExtra1 = viewFacade.getRegistroView().txtAtributoExtra1.getText();
					modelFacade.getcDAO()
							.create(new CiclistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula, aniosExp,
									nacionalidad, tipoCiclista, contextura, tiempoAcumylado, especialidad,
									cadenciaPedaleo, atributoExtra1, atributoExtra2, atributoExtra3, llenoDatos));
					break;

				}
				case "Sprinters": {
					atributoExtra1 = viewFacade.getRegistroView().txtAtributoExtra1.getText();
					atributoExtra2 = viewFacade.getRegistroView().txtAtributoExtra2.getText();
					modelFacade.getcDAO()
							.create(new CiclistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula, aniosExp,
									nacionalidad, tipoCiclista, contextura, tiempoAcumylado, especialidad,
									cadenciaPedaleo, atributoExtra1, atributoExtra2, atributoExtra3, llenoDatos));
					break;

				}
				case "Gregarios": {
					atributoExtra1 = viewFacade.getRegistroView().listFuncionDeGregario.getSelectedValue().toString();
					modelFacade.getcDAO()
							.create(new CiclistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula, aniosExp,
									nacionalidad, tipoCiclista, contextura, tiempoAcumylado, especialidad,
									cadenciaPedaleo, atributoExtra1, atributoExtra2, atributoExtra3, llenoDatos));
					break;

				}
				case "Clasicómanos": {
					atributoExtra1 = viewFacade.getRegistroView().txtAtributoExtra1.getText();
					modelFacade.getcDAO()
							.create(new CiclistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula, aniosExp,
									nacionalidad, tipoCiclista, contextura, tiempoAcumylado, especialidad,
									cadenciaPedaleo, atributoExtra1, atributoExtra2, atributoExtra3, llenoDatos));
					break;

				}
				case "Contrarrelojista": {
					atributoExtra1 = viewFacade.getRegistroView().txtAtributoExtra1.getText();
					modelFacade.getcDAO()
							.create(new CiclistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula, aniosExp,
									nacionalidad, tipoCiclista, contextura, tiempoAcumylado, especialidad,
									cadenciaPedaleo, atributoExtra1, atributoExtra2, atributoExtra3, llenoDatos));
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "Algo salio Mal");
				}
				break;
			}
			}
			createEmail();
			sentEmail();

			viewFacade.getRegistroView().txtUsuario.setText("");
			viewFacade.getRegistroView().txtClave.setText("");
			viewFacade.getRegistroView().txtCorreo.setText("");
			viewFacade.getRegistroView().txtNombre.setText("");
			viewFacade.getRegistroView().txtCedula.setText("");
			viewFacade.getRegistroView().txtAnosExperiencia.setText("");
			;
			viewFacade.getRegistroView().txtNacionalidad.setText("");
			viewFacade.getRegistroView().txtContextura.setText("");
			viewFacade.getRegistroView().txtEspecialidad.setText("");
			viewFacade.getRegistroView().txtCadenciaPedaleo.setText("");

			JOptionPane.showMessageDialog(null, "Datos del " + tipoUsuario + " Guardados con exito");

			break;

		}
		case "DatosPersonales": {
			viewFacade.getPanelPrincipal().setVisible(false);
			viewFacade.getDatosPersonalesView().setVisible(true);

			switch (rangoUsuario) {
			case "Administrador": {
				viewFacade.getDatosPersonalesView().txtNombre.setText("Administrador");
				viewFacade.getDatosPersonalesView().txtCedula.setText("Administrador");
				viewFacade.getDatosPersonalesView().txtAnosExperiencia.setText("Administrador");
				viewFacade.getDatosPersonalesView().txtNacionalidad.setText("Colombia");
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra3.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra3.setVisible(false);
				break;
			}
			case "Director Deportivo": {

				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra3.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra3.setVisible(false);

				ArrayList<DirectorDeportivoDTO> listaDirectores = modelFacade.getDdDAO().getList();
				for (DirectorDeportivoDTO directorDeportivoDTO : listaDirectores) {
					if (directorDeportivoDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
						viewFacade.getDatosPersonalesView().txtNombre.setText(directorDeportivoDTO.getNombre());
						viewFacade.getDatosPersonalesView().txtCedula
								.setText(String.valueOf(directorDeportivoDTO.getIdentificador()));
						viewFacade.getDatosPersonalesView().txtAnosExperiencia
								.setText(String.valueOf(directorDeportivoDTO.getAniosExp()));
						viewFacade.getDatosPersonalesView().txtNacionalidad
								.setText(directorDeportivoDTO.getNacionalidad());
						break;
					}
				}
				break;
			}
			case "Masajista": {
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra3.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra3.setVisible(false);

				ArrayList<MasajistaDTO> lista = modelFacade.getmDAO().getLista();
				for (MasajistaDTO masajistaDTO : lista) {
					if (masajistaDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
						viewFacade.getDatosPersonalesView().txtNombre.setText(masajistaDTO.getNombre());
						viewFacade.getDatosPersonalesView().txtCedula
								.setText(String.valueOf(masajistaDTO.getIdentificador()));
						viewFacade.getDatosPersonalesView().txtAnosExperiencia
								.setText(String.valueOf(masajistaDTO.getAniosExp()));
						viewFacade.getDatosPersonalesView().txtNacionalidad.setText(masajistaDTO.getNacionalidad());
						break;
					}
				}
				break;
			}
			case "Ciclista": {
				viewFacade.getDatosPersonalesView().lblTipoDeCiclista.setVisible(true);
				viewFacade.getDatosPersonalesView().listTipoDeCiclista.setVisible(true);
				viewFacade.getDatosPersonalesView().lblEspecialidad.setVisible(true);
				viewFacade.getDatosPersonalesView().txtEspecialidad.setVisible(true);
				viewFacade.getDatosPersonalesView().lblContextura.setVisible(true);
				viewFacade.getDatosPersonalesView().txtContextura.setVisible(true);
				viewFacade.getDatosPersonalesView().btnSeleccionarTipoDeCiclista.setVisible(true);

				ArrayList<CiclistaDTO> lista = modelFacade.getcDAO().getLista();
				for (CiclistaDTO ciclistaDTO : lista) {
					if (ciclistaDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
						viewFacade.getDatosPersonalesView().txtNombre.setText(ciclistaDTO.getNombre());
						viewFacade.getDatosPersonalesView().txtCedula
								.setText(String.valueOf(ciclistaDTO.getIdentificador()));
						viewFacade.getDatosPersonalesView().txtAnosExperiencia
								.setText(String.valueOf(ciclistaDTO.getAniosExp()));
						viewFacade.getDatosPersonalesView().txtNacionalidad.setText(ciclistaDTO.getNacionalidad());
						viewFacade.getDatosPersonalesView().txtEspecialidad.setText(ciclistaDTO.getEspecialidad());
						viewFacade.getDatosPersonalesView().txtContextura.setText(ciclistaDTO.getEspecialidad());
						String tempTipoCiclista = ciclistaDTO.getTipoCiclista();
						indexValue = 0;
						switch (tempTipoCiclista) {
						case "Escaladores": {
							indexValue = 0;
							break;
						}
						case "Rodadores": {
							indexValue = 1;
							break;
						}
						case "Sprinters": {
							indexValue = 2;
							break;
						}
						case "Gregarios": {
							indexValue = 3;
							break;
						}
						case "Clasicómanos": {
							indexValue = 4;
							break;
						}
						case "Contrarrelojista": {
							indexValue = 5;
							break;
						}
						default:
							break;
						}
						viewFacade.getDatosPersonalesView().listTipoDeCiclista.setSelectedIndex(indexValue);
						viewFacade.getDatosPersonalesView().txtAtributoExtra1.setText(ciclistaDTO.getAtributoExtra1());
						viewFacade.getDatosPersonalesView().txtAtributoExtra2.setText(ciclistaDTO.getAtributoExtra2());
						viewFacade.getDatosPersonalesView().txtAtributoExtra3.setText(ciclistaDTO.getAtributoExtra3());
						break;
					}
				}
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Algo salio mal");
				break;
			}
			}

			break;

		}
		case "RegresarDatosPersonales": {
			viewFacade.getPanelPrincipal().setVisible(true);
			viewFacade.getDatosPersonalesView().setVisible(false);

			break;

		}
		case "TipoCiclista": {

			String tipoCiclista = (String) viewFacade.getDatosPersonalesView().listTipoDeCiclista.getSelectedValue();
			switch (tipoCiclista) {

			case "Escaladores": {
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra3.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra3.setVisible(false);

				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setText("Aceleración En Subida:");
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(true);

				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setText("grado de rampa soportada:");
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(true);

				break;
			}
			case "Rodadores": {
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra3.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra3.setVisible(false);

				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setText("Velocidad Promedio De Pedaleo:");
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(true);

				break;

			}
			case "Sprinters": {
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra3.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra3.setVisible(false);

				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setText("Potencia Promedio:");
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(true);

				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setText("Velocidad Promedio:");
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(true);

				break;

			}
			case "Gregarios": {
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(true);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra3.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra3.setVisible(false);

				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setText("Especiliadad De Gregario:");
				viewFacade.getDatosPersonalesView().lblListaGregario.setLocation(248, 30);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setLocation(258, 55);
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);

				break;

			}
			case "Clasicómanos": {
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);

				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setText("Numero De Clasicos Ganados:");
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(true);

				break;

			}
			case "Contrarrelojista": {
				viewFacade.getDatosPersonalesView().lblListaGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().listFuncionDeGregario.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(false);
				viewFacade.getDatosPersonalesView().lblAtributoExtra2.setVisible(false);
				viewFacade.getDatosPersonalesView().txtAtributoExtra2.setVisible(false);

				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setText("Velocidad Maxima:");
				viewFacade.getDatosPersonalesView().lblAtributoExtra1.setVisible(true);
				viewFacade.getDatosPersonalesView().txtAtributoExtra1.setVisible(true);

				break;

			}
			default:
				JOptionPane.showMessageDialog(null, "Algo salio Mal");
			}
			break;
		}
		case "AbrirCrearEscuadra": {
			viewFacade.getPanelPrincipal().setVisible(false);
			viewFacade.getCrearEscuadraView().setVisible(true);

			break;
		}
		case "CrearEscuadraRegreso": {
			viewFacade.getPanelPrincipal().setVisible(true);
			viewFacade.getCrearEscuadraView().setVisible(false);
			break;
		}
		case "SeleccionarCiclista": {
			int filaSelect = viewFacade.getCrearEscuadraView().tableCiclistas.getSelectedRow();
			if (filaSelect != -1) {
				viewFacade.getCrearEscuadraView().txtNombre
						.setText((String) viewFacade.getCrearEscuadraView().tableCiclistas.getValueAt(filaSelect, 0));
				String nombre = (String) viewFacade.getCrearEscuadraView().tableCiclistas.getValueAt(filaSelect, 0);

				ArrayList<CiclistaDTO> lista = modelFacade.getcDAO().getLista();
				for (CiclistaDTO ciclistaDTO : lista) {
					if (ciclistaDTO.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
						viewFacade.getCrearEscuadraView().txtNombre.setText(ciclistaDTO.getNombre());
						viewFacade.getCrearEscuadraView().txtCedula
								.setText(String.valueOf(ciclistaDTO.getIdentificador()));
						viewFacade.getCrearEscuadraView().txtAniosExperiencia
								.setText(String.valueOf(ciclistaDTO.getAniosExp()));
						viewFacade.getCrearEscuadraView().txtNacionalidad.setText(ciclistaDTO.getNacionalidad());
						viewFacade.getCrearEscuadraView().txtEspecialidad.setText(ciclistaDTO.getEspecialidad());
						viewFacade.getCrearEscuadraView().txtContextura.setText(ciclistaDTO.getEspecialidad());
						viewFacade.getCrearEscuadraView().txtTipoCiclista.setText(ciclistaDTO.getTipoCiclista());
						viewFacade.getCrearEscuadraView().txtCadenciaPedaleo.setText(ciclistaDTO.getCadenciaPedaleo());
						viewFacade.getCrearEscuadraView().txtAtributoExtra1.setText(ciclistaDTO.getAtributoExtra1());
						viewFacade.getCrearEscuadraView().txtAtributoExtra2.setText(ciclistaDTO.getAtributoExtra2());
						viewFacade.getCrearEscuadraView().txtAtributoExtra3.setText(ciclistaDTO.getAtributoExtra3());
						viewFacade.getCrearEscuadraView().txtTiempoAcumulado
								.setText(String.valueOf(ciclistaDTO.getTiempoAcumulado()));

						String tipoCiclista = ciclistaDTO.getTipoCiclista();

						switch (tipoCiclista) {

						case "Escaladores": {
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra3.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra3.setVisible(false);

							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setText("Aceleración En Subida:");
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(true);

							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setText("grado de rampa soportada:");
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(true);

							break;
						}
						case "Rodadores": {
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra3.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra3.setVisible(false);

							viewFacade.getCrearEscuadraView().lblAtributoExtra1
									.setText("Velocidad Promedio De Pedaleo:");
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(true);

							break;

						}
						case "Sprinters": {
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra3.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra3.setVisible(false);

							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setText("Potencia Promedio:");
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(true);

							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setText("Velocidad Promedio:");
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(true);

							break;

						}
						case "Gregarios": {
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(true);
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra3.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra3.setVisible(false);

							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setText("Especiliadad De Gregario:");

							break;

						}
						case "Clasicómanos": {

							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(false);

							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setText("Numero De Clasicos Ganados:");
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(true);

							break;

						}
						case "Contrarrelojista": {
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(false);
							viewFacade.getCrearEscuadraView().lblAtributoExtra2.setVisible(false);
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setVisible(false);

							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setText("Velocidad Maxima:");
							viewFacade.getCrearEscuadraView().lblAtributoExtra1.setVisible(true);
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setVisible(true);

							break;

						}
						default:
							JOptionPane.showMessageDialog(null, "Algo salio Mal");
						}
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debes selecionar un ciclista en la tabla");
			}
			break;
		}
		case "AgregarCiclista": {
			if (viewFacade.getCrearEscuadraView().txtNombre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un ciclista primero antes de seleccionarlo");
			} else {
				Object[] fila = new Object[8];
				fila[0] = viewFacade.getCrearEscuadraView().txtNombre.getText();
				fila[1] = viewFacade.getCrearEscuadraView().txtCedula.getText();
				fila[2] = viewFacade.getCrearEscuadraView().txtAniosExperiencia.getText();
				fila[3] = viewFacade.getCrearEscuadraView().txtTipoCiclista.getText();
				fila[4] = viewFacade.getCrearEscuadraView().txtNacionalidad.getText();
				fila[5] = viewFacade.getCrearEscuadraView().txtContextura.getText();
				fila[6] = viewFacade.getCrearEscuadraView().txtTiempoAcumulado.getText();
				fila[7] = viewFacade.getCrearEscuadraView().txtEspecialidad.getText();
				viewFacade.getCrearEscuadraView().modelTablaEscuadra.addRow(fila);
			}
			if (viewFacade.getCrearEscuadraView().txtNombre.getText().isEmpty()) {

			} else {
				nombreCiclista.add(viewFacade.getCrearEscuadraView().txtNombre.getText());
			}

			if (nombreCiclista.size() == 6) {
				viewFacade.getCrearEscuadraView().btnAgregar.setEnabled(false);
			}

			System.out.println(nombreCiclista);
			break;
		}
		case "EliminarCiclista": {

			int index = viewFacade.getCrearEscuadraView().tablaEscuadra.getSelectedRow();
			if (index != -1) {
				viewFacade.getCrearEscuadraView().modelTablaEscuadra.removeRow(index);
				nombreCiclista.remove(index);
				System.out.println(nombreCiclista);
				viewFacade.getCrearEscuadraView().btnAgregar.setEnabled(true);

			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un ciclista");
			}

			break;
		}
		case "CrearEscuadra": {
			if (nombreCiclista.size() != 6) {
				JOptionPane.showMessageDialog(null, "La escuadra debe tener al menos 6 ciclistas");
			} else {
				String nombreEscuadra = JOptionPane.showInputDialog("Cual es el nombre de su escuadra?");
				String nacionalidad = JOptionPane.showInputDialog("Cual es la nacionalidad de su escuadra?");
				String ciclista1 = nombreCiclista.get(0);
				String ciclista2 = nombreCiclista.get(1);
				String ciclista3 = nombreCiclista.get(2);
				String ciclista4 = nombreCiclista.get(3);
				String ciclista5 = nombreCiclista.get(4);
				String ciclista6 = nombreCiclista.get(5);
				String directorTecnicoUser = viewFacade.getPanelPrincipal().lblBienvenido.getText();
				String directorTecnico = "No hay";

				ArrayList<DirectorDeportivoDTO> listaDirectores = modelFacade.getDdDAO().getList();
				System.out.println(listaDirectores.size());
				for (int i = 0; i < listaDirectores.size(); i++) {

					System.out
							.println("Director Tecnico Guardado: " + listaDirectores.get(i).getUsuario().toUpperCase());
					System.out.println("Director Tecnico Del Label: " + directorTecnicoUser.toUpperCase());

					if (listaDirectores.get(i).getUsuario().toUpperCase().equals(directorTecnicoUser.toUpperCase())) {
						System.out.println("Entro");
						directorTecnico = listaDirectores.get(i).getNombre();
						String usuario = listaDirectores.get(i).getUsuario();
						String clave = listaDirectores.get(i).getClave();
						String tipoUsuario = listaDirectores.get(i).getTipoDeUsuario();
						String correo = listaDirectores.get(i).getCorreo();
						int id = listaDirectores.get(i).getId();
						String nombre = listaDirectores.get(i).getNombre();
						long identificador = listaDirectores.get(i).getIdentificador();
						int aniosExp = listaDirectores.get(i).getAniosExp();
						String nacionalidadD = listaDirectores.get(i).getNacionalidad();

						modelFacade.getDdDAO().update(i, new DirectorDeportivoDTO(usuario, clave, tipoUsuario, correo,
								id, nombre, identificador, aniosExp, nacionalidadD, nombreEscuadra));
						break;
					}
				}

				int listasize = modelFacade.getmDAO().getLista().size();
				Random random = new Random();
				int randonIndex = random.nextInt(listasize + 1);
				ArrayList<MasajistaDTO> lista = modelFacade.getmDAO().getLista();

				// String masajista = lista.get(0).getNombre();
				System.out.println(directorTecnicoUser);

				modelFacade.geteDAO().create(new EscuadraDTO(nombreEscuadra, nacionalidad, ciclista1, ciclista2,
						ciclista3, ciclista4, ciclista5, ciclista6, "Masajista1", directorTecnico));
				JOptionPane.showMessageDialog(null, "Escuadra Creada con exito");
				viewFacade.getCrearEscuadraView().btnCrear.setEnabled(false);
				viewFacade.getCrearEscuadraView().btnEliminar.setEnabled(false);
			}
			break;
		}
		case "MiEscuadra": {
			viewFacade.getPanelPrincipal().setVisible(false);
			viewFacade.getEscuadraView().setVisible(true);

			modelEscuadra = new DefaultTableModel();
			viewFacade.getEscuadraView().tableMiEscuadra.setModel(modelEscuadra);
			modelEscuadra.addColumn("Nombre");
			modelEscuadra.addColumn("Nacionalidad");
			modelEscuadra.addColumn("Tipo Ciclista");
			modelEscuadra.addColumn("Años De Experiencia");
			modelEscuadra.addColumn("Tiempo Acumulado");
			modelEscuadra.addColumn("Cadencia De Pedaleo");
			llenarTabla();

			break;
		}case "RegresarEscuadra":{
			viewFacade.getPanelPrincipal().setVisible(true);
			viewFacade.getEscuadraView().setVisible(false);
			break;
		}
		default: {
			JOptionPane.showMessageDialog(null, "Algo salio mal");
		}
		}

	}

	/*
	 * Contiene la informacion referente a la creacion del Email en el programa.
	 */
	private void llenarTabla() {
		
		String tipoUsuario = viewFacade.getPanelPrincipal().lblRol.getText();
	
		String nombreDirector = "";
		String nombreEscuadra = "";
		String[] cilistas = new String[6];
		
		switch (tipoUsuario) {
		case "Director Deportivo":{
			ArrayList<DirectorDeportivoDTO> listaDirectores = modelFacade.getDdDAO().getList();
			for (DirectorDeportivoDTO directorDeportivoDTO : listaDirectores) {
				if (directorDeportivoDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
					nombreDirector = directorDeportivoDTO.getNombre();
					nombreEscuadra = directorDeportivoDTO.getNombreEscuadra();
					break;
				}
			}

			viewFacade.getEscuadraView().lblTitulo.setText("Mi Escuadra: " + nombreEscuadra);

			ArrayList<EscuadraDTO> listaEscuadra = modelFacade.geteDAO().getLista();
			for (EscuadraDTO escuadraDTO : listaEscuadra) {
				if (escuadraDTO.getDirectorTecnico().toUpperCase().equals(nombreDirector.toUpperCase())) {
					cilistas[0] = escuadraDTO.getCiclista1();
					cilistas[1] = escuadraDTO.getCiclista2();
					cilistas[2] = escuadraDTO.getCiclista3();
					cilistas[3] = escuadraDTO.getCiclista4();
					cilistas[4] = escuadraDTO.getCiclista5();
					cilistas[5] = escuadraDTO.getCiclista6();
					break;
				}
			}

			ArrayList<CiclistaDTO> listaCiclista = modelFacade.getcDAO().getLista();
			for (CiclistaDTO ciclistaDTO : listaCiclista) {
				for (int i = 0; i < cilistas.length; i++) {
					if (ciclistaDTO.getNombre().toUpperCase().equals(cilistas[i].toUpperCase())) {
						Object[] fila = new Object[6];
						fila[0] = ciclistaDTO.getNombre();
						fila[1] = ciclistaDTO.getNacionalidad();
						fila[2] = ciclistaDTO.getTipoCiclista();
						fila[3] = ciclistaDTO.getAniosExp();
						fila[4] = ciclistaDTO.getTiempoAcumulado();
						fila[5] = ciclistaDTO.getCadenciaPedaleo();
						modelEscuadra.addRow(fila);		
					}
				}
			}
			break;
		}case "Ciclista":{
			
			break;
		}
		default:
			break;
		}
	}

	private void createEmail() {
		emailTo = correo;
		content = "Usted Fue Exitosamente Registrado en el sistema ISUCI. Sus Datos son los Siguientes: Usuario: "
				+ usuario + " \nId: " + id + " Password: " + clave + " Correo: " + correo;

		// Simple mail transfer protocol
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", emailFrom);
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");

		mSession = Session.getDefaultInstance(mProperties);

		mCorreo = new MimeMessage(mSession);
		try {
			// Creacion del Cuerpo del Correo
			mCorreo.setFrom(new InternetAddress(emailFrom));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mCorreo.setSubject(subject);
			mCorreo.setText(content, "ISO-8859-1", "html");

		} catch (MessagingException e) {
			System.out.println("No se pudo Crear el Gmail");
			e.printStackTrace();
		}
	}

	/**
	 * Contiene la informacion referente del envio del Email dentro del programa.
	 */

	private void sentEmail() {
		try {
			Transport mTransport = mSession.getTransport("smtp");
			mTransport.connect(emailFrom, passwordFrom);
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();

			JOptionPane.showMessageDialog(null, "Correo De Confirmación Enviado Con Exito");
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "No se pudo enviar el correo");
			System.out.println("No se pudo enviar el correo");
			e.printStackTrace();
		}
	}
}
