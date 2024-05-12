package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La clase RegistroView se encarga de mostrar la ventana de registro del
 * Aplicativo. Contiene los recuadros de la informacion para registrarse en la
 * aplicacion.
 */
public class RegistroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtUsuario;
	public JTextField txtClave;
	@SuppressWarnings("rawtypes")
	public JList listTipoDeUsuario;
	private JLabel lblUsuario_2;
	private JLabel lblClave;
	private JLabel lblUsuario;
	private JPanel panel;
	private JLabel lblTitulo;
	public JButton btnCrearUsuario;
	public JTextField txtCorreo;

	/**
	 * El constructor de la clase RegistroView se encarga de inicializar y mostrar
	 * toda la vista de la ventana de registro de usuarios del aplicativo.
	 */

	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public RegistroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 453, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitulo = new JLabel("Registro De Usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(151, 11, 150, 24);
		contentPane.add(lblTitulo);

		panel = new JPanel();
		panel.setBounds(36, 46, 380, 178);
		contentPane.add(panel);
		panel.setLayout(null);

		lblUsuario = new JLabel("Nombre de Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 11, 128, 14);
		panel.add(lblUsuario);

		lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClave.setBounds(10, 122, 104, 14);
		panel.add(lblClave);

		lblUsuario_2 = new JLabel("Tipo de Usuario:");
		lblUsuario_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario_2.setBounds(219, 11, 104, 14);
		panel.add(lblUsuario_2);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 33, 185, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JTextField();
		txtClave.setBounds(10, 147, 185, 20);
		panel.add(txtClave);
		txtClave.setColumns(10);

		listTipoDeUsuario = new JList();
		listTipoDeUsuario.setModel(new AbstractListModel() {
			String[] values = new String[] { "Ciclista", "Masajista", "Director Deportivo", "Administrador" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listTipoDeUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTipoDeUsuario.setBounds(219, 35, 141, 72);
		panel.add(listTipoDeUsuario);

		btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(199, 144, 161, 23);
		panel.add(btnCrearUsuario);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 64, 104, 14);
		panel.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(10, 89, 185, 20);
		panel.add(txtCorreo);
	}
}
