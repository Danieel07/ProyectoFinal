package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.ModelFacade;
import co.edu.unbosque.view.LoginView;
import co.edu.unbosque.view.RegistroView;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener{
	
	//Enviar Gmail
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
	private int id = 0;
	
	
	public Controller() {	
		viewFacade = new ViewFacade();
		modelFacade = new ModelFacade();
		mProperties = new Properties();
		listeners();
	}
	
	public void run() {
		viewFacade.getLoginView().setVisible(true);
	}
	public void listeners() {
		//Login View
		viewFacade.getLoginView().btnRegistro.addActionListener(this);
		viewFacade.getLoginView().btnRegistro.setActionCommand("AbrirViewRegistro");
				
		//Registro View
		viewFacade.getRegistroView().btnCrearUsuario.addActionListener(this);
		viewFacade.getRegistroView().btnCrearUsuario.setActionCommand("CrearUsuario");
		
		
		
	}

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
		
		case "CrearUsuario":{
			//Tomar Datos
			usuario = viewFacade.getRegistroView().txtUsuario.getText();
			clave = viewFacade.getRegistroView().txtClave.getText();
			tipoUsuario = (String) viewFacade.getRegistroView().listTipoDeUsuario.getSelectedValue();
			correo = viewFacade.getRegistroView().txtCorreo.getText();
			
			//Enviar Datos y Crear Usuario
			modelFacade.getuDAO().create(new UsuarioDTO(usuario, clave, tipoUsuario, correo, 0));
			
			//Vaciar Campos de Texto
			viewFacade.getRegistroView().txtUsuario.setText("");
			viewFacade.getRegistroView().txtClave.setText("");
			viewFacade.getRegistroView().listTipoDeUsuario.setSelectedIndex(-1);
		
			//Enviar Email
			createEmail();
			sentEmail();
			
			//Confirmar al usuario que todo salio bien
			JOptionPane.showMessageDialog(null, "Usuario Creado Con Exito");
			viewFacade.getLoginView().setVisible(true);
			viewFacade.getRegistroView().setVisible(false);
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, "Algo salio mal");
		}
		
	}

	private void createEmail() {
		emailTo = correo;
		content = "Usted Fue Exitosamente Registrado en el sistema ISUCI. Sus Datos son los Siguientes: Usuario: "+ usuario +
				" \nId: " +id + " Password: "+ clave + " Correo: " + correo;
		
		// Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
        mCorreo = new MimeMessage(mSession);
        try {
        	//Creacion del Cuerpo del Correo
			mCorreo.setFrom(new InternetAddress(emailFrom));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mCorreo.setSubject(subject);
			mCorreo.setText(content, "ISO-8859-1", "html");
			
		} catch (MessagingException e) {
			System.out.println("No se pudo Crear el Gmail");
			e.printStackTrace();
		}
	} 

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

