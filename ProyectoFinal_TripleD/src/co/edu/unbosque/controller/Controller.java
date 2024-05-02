package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import co.edu.unbosque.model.UsuariosDTO;
import co.edu.unbosque.model.persistence.ModelFacade;
import co.edu.unbosque.view.LoginView;
import co.edu.unbosque.view.RegistroView;

public class Controller implements ActionListener{
	private LoginView lgv;
	private RegistroView rv;
	private ModelFacade mf;
	
	
	public Controller() {	
		lgv = new LoginView();	
		rv = new RegistroView();
		mf = new ModelFacade();
		oyentes();
	}
	
	public void run() {
		lgv.setVisible(true);
	}
	public void oyentes() {
		rv.btnCrearUsuario.addActionListener(this);
		rv.btnCrearUsuario.setActionCommand("CrearUsuario");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CrearUsuario")) {
			String usuario = rv.txtUsuario.getText();
			String clave = rv.txtClave.getText();
			String tipoUsuario = (String) rv.listTipoDeUsuario.getSelectedValue();
			mf.getuDAO().create(new UsuariosDTO(usuario, clave, tipoUsuario));
			rv.txtUsuario.setText("");
			rv.txtClave.setText("");
			rv.listTipoDeUsuario.setSelectedIndex(-1);
			System.out.println("Usuario Creado Con Exito");
			JOptionPane.showMessageDialog(null, "Usuario Creado Con Exito");
			lgv.setVisible(true);
			rv.dispose();
		}
	}
}
