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
	public JPanel panelUno;
	private JLabel lblTitulo;
	public JButton btnCrearUsuario;
	public JTextField txtCorreo;
	public JButton btnRegresar;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtAnosExperiencia;
	public JTextField txtEspecialidad;
	public JTextField txtContextura;
	public JTextField txtCadenciaPedaleo;
	public JTextField txtNacionalidad;
	public JTextField txtAtributoExtra1;
	public JTextField txtAtributoExtra2;
	public JTextField txtAtributoExtra3;
	public JButton btnSeleccionarTipoDeCiclista;
	public JButton btnGuardarDatos;
	public JList<String> listTipoDeCiclista;
	public JLabel lblAtributoExtra1;
	public JLabel lblAtributoExtra2;
	public JLabel lblAtributoExtra3;
	public JList<String> listFuncionDeGregario;
	public JLabel lblListaGregario;
	public JPanel panel2;
	public JLabel lblTipoDeCiclista;
	public JLabel lblNacionalidad;
	public JLabel lblCedula;
	public JLabel lblAosDeExperiencia;
	public JLabel lblNombre;
	public JLabel lblEspecialidad;
	public JLabel lblContextura;
	public JLabel lblCadenciaDePedaleo;
	public JLabel lblCorreo;

	/**
	 * El constructor de la clase RegistroView se encarga de inicializar y mostrar
	 * toda la vista de la ventana de registro de usuarios del aplicativo.
	 */

	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public RegistroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 933, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitulo = new JLabel("Registro De Usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(379, 11, 150, 24);
		contentPane.add(lblTitulo);

		panelUno = new JPanel();
		panelUno.setBounds(24, 46, 380, 178);
		contentPane.add(panelUno);
		panelUno.setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 11, 128, 14);
		panelUno.add(lblUsuario);

		lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClave.setBounds(10, 122, 104, 14);
		panelUno.add(lblClave);

		lblUsuario_2 = new JLabel("Tipo de Usuario:");
		lblUsuario_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario_2.setBounds(219, 11, 104, 14);
		panelUno.add(lblUsuario_2);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 33, 185, 20);
		panelUno.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JTextField();
		txtClave.setBounds(10, 147, 185, 20);
		panelUno.add(txtClave);
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
		panelUno.add(listTipoDeUsuario);

		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 64, 104, 14);
		panelUno.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(10, 89, 185, 20);
		panelUno.add(txtCorreo);
		
				btnCrearUsuario = new JButton("Seleccionar");
				btnCrearUsuario.setBounds(209, 147, 161, 22);
				panelUno.add(btnCrearUsuario);
		contentPane.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setVisible(false);
		panel2.setBounds(422, 46, 485, 582);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		btnGuardarDatos = new JButton("Guardar");
		btnGuardarDatos.setBounds(359, 537, 118, 38);
		panel2.add(btnGuardarDatos);
		
		txtCadenciaPedaleo = new JTextField();
		txtCadenciaPedaleo.setVisible(false);
		txtCadenciaPedaleo.setBounds(40, 522, 165, 20);
		panel2.add(txtCadenciaPedaleo);
		txtCadenciaPedaleo.setColumns(10);
		
		lblCadenciaDePedaleo = new JLabel("Cadencia de pedaleo:");
		lblCadenciaDePedaleo.setVisible(false);
		lblCadenciaDePedaleo.setBounds(30, 497, 175, 14);
		panel2.add(lblCadenciaDePedaleo);
		lblCadenciaDePedaleo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtContextura = new JTextField();
		txtContextura.setVisible(false);
		txtContextura.setBounds(40, 466, 165, 20);
		panel2.add(txtContextura);
		txtContextura.setColumns(10);
		
		lblContextura = new JLabel("Contextura:");
		lblContextura.setVisible(false);
		lblContextura.setBounds(30, 441, 118, 14);
		panel2.add(lblContextura);
		lblContextura.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setVisible(false);
		txtEspecialidad.setBounds(40, 410, 165, 20);
		panel2.add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setVisible(false);
		lblEspecialidad.setBounds(30, 385, 118, 14);
		panel2.add(lblEspecialidad);
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		listTipoDeCiclista = new JList<String>();
		listTipoDeCiclista.setVisible(false);
		listTipoDeCiclista.setBounds(40, 260, 165, 123);
		panel2.add(listTipoDeCiclista);
		listTipoDeCiclista.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3149124928780777305L;
			String[] values = new String[] {"Escaladores", "Rodadores", "Sprinters", "Gregarios", "Clasicómanos", "Contrarrelojista"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		btnSeleccionarTipoDeCiclista = new JButton("Seleccionar");
		btnSeleccionarTipoDeCiclista.setVisible(false);
		btnSeleccionarTipoDeCiclista.setBounds(215, 360, 118, 23);
		panel2.add(btnSeleccionarTipoDeCiclista);
		
		listFuncionDeGregario = new JList<String>();
		listFuncionDeGregario.setBounds(258, 206, 165, 100);
		panel2.add(listFuncionDeGregario);
		listFuncionDeGregario.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = -3462223230159663809L;
			String[] values = new String[] {"Abastecedor", "Mantener Ritmo", "Captura de Fugas", "Posicionar al Lider", "Proteger al Lider"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(40, 204, 165, 20);
		panel2.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		lblTipoDeCiclista = new JLabel("Tipo De Ciclista:");
		lblTipoDeCiclista.setVisible(false);
		lblTipoDeCiclista.setBounds(30, 235, 175, 14);
		panel2.add(lblTipoDeCiclista);
		lblTipoDeCiclista.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(30, 179, 175, 14);
		panel2.add(lblNacionalidad);
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblListaGregario = new JLabel("Función en el Peloton:");
		lblListaGregario.setBounds(245, 175, 272, 23);
		panel2.add(lblListaGregario);
		lblListaGregario.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtAtributoExtra3 = new JTextField();
		txtAtributoExtra3.setBounds(258, 148, 165, 20);
		panel2.add(txtAtributoExtra3);
		txtAtributoExtra3.setColumns(10);
		
		lblAtributoExtra3 = new JLabel("Extra3:");
		lblAtributoExtra3.setBounds(248, 123, 357, 20);
		panel2.add(lblAtributoExtra3);
		lblAtributoExtra3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtAtributoExtra2 = new JTextField();
		txtAtributoExtra2.setBounds(258, 92, 165, 20);
		panel2.add(txtAtributoExtra2);
		txtAtributoExtra2.setColumns(10);
		
		lblAtributoExtra2 = new JLabel("Extra2:");
		lblAtributoExtra2.setBounds(248, 67, 357, 23);
		panel2.add(lblAtributoExtra2);
		lblAtributoExtra2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		//agg
		txtAtributoExtra1 = new JTextField();
		txtAtributoExtra1.setBounds(258, 36, 165, 20);
		panel2.add(txtAtributoExtra1);
		txtAtributoExtra1.setColumns(10);
		
		lblAtributoExtra1 = new JLabel("Extra1:");
		lblAtributoExtra1.setBounds(248, 11, 357, 23);
		panel2.add(lblAtributoExtra1);
		lblAtributoExtra1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(40, 36, 165, 20);
		panel2.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(40, 92, 165, 20);
		panel2.add(txtCedula);
		txtCedula.setColumns(10);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(30, 67, 118, 14);
		panel2.add(lblCedula);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblAosDeExperiencia = new JLabel("Años de Experiencia:");
		lblAosDeExperiencia.setBounds(30, 123, 175, 14);
		panel2.add(lblAosDeExperiencia);
		lblAosDeExperiencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtAnosExperiencia = new JTextField();
		txtAnosExperiencia.setBounds(40, 148, 165, 20);
		panel2.add(txtAnosExperiencia);
		txtAnosExperiencia.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 11, 118, 14);
		panel2.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(24, 247, 118, 38);
		contentPane.add(btnRegresar);
		lblAtributoExtra1.setVisible(false);
		txtAtributoExtra1.setVisible(false);
		lblAtributoExtra2.setVisible(false);
		txtAtributoExtra2.setVisible(false);
		lblAtributoExtra3.setVisible(false);
		txtAtributoExtra3.setVisible(false);
		lblListaGregario.setVisible(false);
		listFuncionDeGregario.setVisible(false);
		
	}
}
