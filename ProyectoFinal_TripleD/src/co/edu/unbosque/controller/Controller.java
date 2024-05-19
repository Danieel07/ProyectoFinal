package co.edu.unbosque.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

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
				viewFacade.getPanelPrincipal().lblBienvenido.setText("Bienvenido " + usuarioLogin.toUpperCase());

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
							viewFacade.getPanelPrincipal().btnCrearEscuadra.setVisible(true);
							viewFacade.getPanelPrincipal().btnSimularCarrera.setVisible(true);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setVisible(true);
							viewFacade.getPanelPrincipal().btnGenerarReporte.setBounds(174, 354, 264, 41);
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
			id = modelFacade.getuDAO().getLista().get(modelFacade.getuDAO().getLista().size() - 1).getId() + 1;

			switch (tipoUsuario) {
			case "Administrador": {
				modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, id));
				break;
			}
			case "Director Deportivo": {
				modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, id));
				modelFacade.getDdDAO().create(new DirectorDeportivoDTO(usuario.toUpperCase(), clave, tipoUsuario, correo, id, nombre,
						cedula, aniosExp, nacionalidad));
				break;
			}
			case "Masajista": {
				modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, id));
				modelFacade.getmDAO().create(new MasajistaDTO(usuario, clave, tipoUsuario, correo, id, nombre, cedula, aniosExp, nacionalidad, "1"));

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
				viewFacade.getDatosPersonalesView().txtAnosExperiencia .setText("Administrador");
				viewFacade.getDatosPersonalesView().txtNacionalidad.setText("Colombia");
				break;
			}
			case "Director Deportivo": {
				ArrayList<DirectorDeportivoDTO> listaDirectores = modelFacade.getDdDAO().getList();
				for (DirectorDeportivoDTO directorDeportivoDTO : listaDirectores) {
						if(directorDeportivoDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
							viewFacade.getDatosPersonalesView().txtNombre.setText(directorDeportivoDTO.getNombre());
							viewFacade.getDatosPersonalesView().txtCedula.setText(String.valueOf(directorDeportivoDTO.getIdentificador()));
							viewFacade.getDatosPersonalesView().txtAnosExperiencia .setText(String.valueOf(directorDeportivoDTO.getAniosExp()));
							viewFacade.getDatosPersonalesView().txtNacionalidad.setText(directorDeportivoDTO.getNacionalidad());
							break;
						}
					}
				break;
			}
			case "Masajista": {
				ArrayList<MasajistaDTO> lista = modelFacade.getmDAO().getList();
				for (MasajistaDTO masajistaDTO : lista) {
						if(masajistaDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
							viewFacade.getDatosPersonalesView().txtNombre.setText(masajistaDTO.getNombre());
							viewFacade.getDatosPersonalesView().txtCedula.setText(String.valueOf(masajistaDTO.getIdentificador()));
							viewFacade.getDatosPersonalesView().txtAnosExperiencia .setText(String.valueOf(masajistaDTO.getAniosExp()));
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
						if(ciclistaDTO.getUsuario().toUpperCase().equals(usuarioLogin.toUpperCase())) {
							viewFacade.getDatosPersonalesView().txtNombre.setText(ciclistaDTO.getNombre());
							viewFacade.getDatosPersonalesView().txtCedula.setText(String.valueOf(ciclistaDTO.getIdentificador()));
							viewFacade.getDatosPersonalesView().txtAnosExperiencia .setText(String.valueOf(ciclistaDTO.getAniosExp()));
							viewFacade.getDatosPersonalesView().txtNacionalidad.setText(ciclistaDTO.getNacionalidad());
							viewFacade.getDatosPersonalesView().txtEspecialidad.setText(ciclistaDTO.getEspecialidad());
							viewFacade.getDatosPersonalesView().txtContextura.setText(ciclistaDTO.getEspecialidad());
							String tempTipoCiclista = ciclistaDTO.getTipoCiclista();
							indexValue = 0;
							switch (tempTipoCiclista) {
							case "Escaladores":{
								indexValue = 0;
								break;
							}case "Rodadores":{
								indexValue = 1;
								break;
							}case "Sprinters":{
								indexValue = 2;
								break;
							}case "Gregarios":{
								indexValue = 3;
								break;
							}case "Clasicómanos":{
								indexValue = 4;
								break;
							}case "Contrarrelojista":{
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
			default:{
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

		}case "TipoCiclista":{
			
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
		}case "AbrirCrearEscuadra":{
			viewFacade.getPanelPrincipal().setVisible(false);
			viewFacade.getCrearEscuadraView().setVisible(true);
			
			break;
		}case "CrearEscuadraRegreso":{
			viewFacade.getPanelPrincipal().setVisible(true);
			viewFacade.getCrearEscuadraView().setVisible(false);
			break;
		}case "SeleccionarCiclista":{
			int filaSelect = viewFacade.getCrearEscuadraView().tableCiclistas.getSelectedRow();
			if (filaSelect != -1) {
				viewFacade.getCrearEscuadraView().txtNombre.setText((String) viewFacade.getCrearEscuadraView().tableCiclistas.getValueAt(filaSelect, 0));
				String nombre = (String) viewFacade.getCrearEscuadraView().tableCiclistas.getValueAt(filaSelect, 0);
				
				ArrayList<CiclistaDTO> lista = modelFacade.getcDAO().getLista();
				for (CiclistaDTO ciclistaDTO : lista) {
						if(ciclistaDTO.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
							viewFacade.getCrearEscuadraView().txtNombre.setText(ciclistaDTO.getNombre());
							viewFacade.getCrearEscuadraView().txtCedula.setText(String.valueOf(ciclistaDTO.getIdentificador()));
							viewFacade.getCrearEscuadraView().txtAniosExperiencia.setText(String.valueOf(ciclistaDTO.getAniosExp()));
							viewFacade.getCrearEscuadraView().txtNacionalidad.setText(ciclistaDTO.getNacionalidad());
							viewFacade.getCrearEscuadraView().txtEspecialidad.setText(ciclistaDTO.getEspecialidad());
							viewFacade.getCrearEscuadraView().txtContextura.setText(ciclistaDTO.getEspecialidad());
							viewFacade.getCrearEscuadraView().txtTipoCiclista.setText(ciclistaDTO.getTipoCiclista());
							viewFacade.getCrearEscuadraView().txtCadenciaPedaleo.setText(ciclistaDTO.getCadenciaPedaleo());
							viewFacade.getCrearEscuadraView().txtAtributoExtra1.setText(ciclistaDTO.getAtributoExtra1());
							viewFacade.getCrearEscuadraView().txtAtributoExtra2.setText(ciclistaDTO.getAtributoExtra2());
							viewFacade.getCrearEscuadraView().txtAtributoExtra3.setText(ciclistaDTO.getAtributoExtra3());
							viewFacade.getCrearEscuadraView().txtTiempoAcumulado.setText(String.valueOf(ciclistaDTO.getTiempoAcumulado()));
							
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

								viewFacade.getCrearEscuadraView().lblAtributoExtra1.setText("Velocidad Promedio De Pedaleo:");
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
			}else {
				JOptionPane.showMessageDialog(null, "Debes selecionar un ciclista en la tabla");
			}
			break;
		}
		case "AgregarCiclista":{
			
		}
		default:{
			JOptionPane.showMessageDialog(null, "Algo salio mal");
			}
		}			
			
	}
	
	/*
	 * Contiene la informacion referente a la creacion del Email en el programa.
	 */

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
