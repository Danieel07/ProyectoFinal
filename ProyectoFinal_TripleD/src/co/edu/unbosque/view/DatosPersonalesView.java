package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DatosPersonalesView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	public JButton btnModificarDatos;
	public JList<String> listTipoDeCiclista;
	public JLabel lblAtributoExtra1;
	public JLabel lblAtributoExtra2;
	public JLabel lblAtributoExtra3;
	public JList<String> listFuncionDeGregario;
	public JLabel lblListaGregario;
	
	public DatosPersonalesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(30, 30, 118, 14);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(40, 55, 165, 20);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(30, 86, 118, 14);
			lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(40, 111, 165, 20);
			txtCedula.setColumns(10);
			getContentPane().add(txtCedula);
			
			JLabel lblAosDeExperiencia = new JLabel("Años de Experiencia:");
			lblAosDeExperiencia.setBounds(30, 142, 175, 14);
			lblAosDeExperiencia.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblAosDeExperiencia);
			
			txtAnosExperiencia = new JTextField();
			txtAnosExperiencia.setBounds(40, 167, 165, 20);
			txtAnosExperiencia.setColumns(10);
			getContentPane().add(txtAnosExperiencia);
			
			JLabel lblNacionalidad = new JLabel("Nacionalidad:");
			lblNacionalidad.setBounds(30, 198, 175, 14);
			lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblNacionalidad);
			
			JLabel lblTipoDeCiclista = new JLabel("Tipo De Ciclista:");
			lblTipoDeCiclista.setBounds(30, 254, 175, 14);
			lblTipoDeCiclista.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblTipoDeCiclista);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.setBounds(40, 429, 165, 20);
			txtEspecialidad.setColumns(10);
			getContentPane().add(txtEspecialidad);
			
			JLabel lblEspecialidad = new JLabel("Especialidad:");
			lblEspecialidad.setBounds(30, 404, 118, 14);
			lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblEspecialidad);
			
			txtContextura = new JTextField();
			txtContextura.setBounds(40, 485, 165, 20);
			txtContextura.setColumns(10);
			getContentPane().add(txtContextura);
			
			JLabel lblContextura = new JLabel("Contextura:");
			lblContextura.setBounds(30, 460, 118, 14);
			lblContextura.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblContextura);
			
			JLabel lblCadenciaDePedaleo = new JLabel("Cadencia de pedaleo:");
			lblCadenciaDePedaleo.setBounds(30, 516, 175, 14);
			lblCadenciaDePedaleo.setFont(new Font("Tahoma", Font.BOLD, 14));
			getContentPane().add(lblCadenciaDePedaleo);
			
			txtCadenciaPedaleo = new JTextField();
			txtCadenciaPedaleo.setBounds(40, 541, 165, 20);
			txtCadenciaPedaleo.setColumns(10);
			getContentPane().add(txtCadenciaPedaleo);
			
			txtNacionalidad = new JTextField();
			txtNacionalidad.setBounds(40, 223, 165, 20);
			txtNacionalidad.setColumns(10);
			getContentPane().add(txtNacionalidad);
			
			listTipoDeCiclista = new JList<String>();
			listTipoDeCiclista.setBounds(40, 279, 165, 123);
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
			getContentPane().add(listTipoDeCiclista);
			
			txtAtributoExtra1 = new JTextField();
			txtAtributoExtra1.setColumns(10);
			txtAtributoExtra1.setBounds(258, 55, 165, 20);
			txtAtributoExtra1.setVisible(false);
			getContentPane().add(txtAtributoExtra1);
			
			lblAtributoExtra1 = new JLabel("Extra1:");
			lblAtributoExtra1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAtributoExtra1.setBounds(248, 30, 357, 23);
			lblAtributoExtra1.setVisible(false);
			getContentPane().add(lblAtributoExtra1);
			
			txtAtributoExtra2 = new JTextField();
			txtAtributoExtra2.setColumns(10);
			txtAtributoExtra2.setBounds(258, 111, 165, 20);
			txtAtributoExtra2.setVisible(false);
			getContentPane().add(txtAtributoExtra2);
			
			lblAtributoExtra2 = new JLabel("Extra2:");
			lblAtributoExtra2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAtributoExtra2.setBounds(248, 86, 357, 23);
			lblAtributoExtra2.setVisible(false);
			getContentPane().add(lblAtributoExtra2);
			
			txtAtributoExtra3 = new JTextField();
			txtAtributoExtra3.setColumns(10);
			txtAtributoExtra3.setBounds(258, 167, 165, 20);
			txtAtributoExtra3.setVisible(false);
			getContentPane().add(txtAtributoExtra3);
			
			lblAtributoExtra3 = new JLabel("Extra3:");
			lblAtributoExtra3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAtributoExtra3.setBounds(248, 142, 357, 20);
			lblAtributoExtra3.setVisible(false);
			getContentPane().add(lblAtributoExtra3);
			
			btnSeleccionarTipoDeCiclista = new JButton("Seleccionar");
			btnSeleccionarTipoDeCiclista.setBounds(215, 379, 118, 23);
			getContentPane().add(btnSeleccionarTipoDeCiclista);
			
			btnGuardarDatos = new JButton("Guardar");
			btnGuardarDatos.setBounds(402, 572, 118, 38);
			getContentPane().add(btnGuardarDatos);
			
			btnModificarDatos = new JButton("Modificar");
			btnModificarDatos.setBounds(245, 572, 118, 38);
			getContentPane().add(btnModificarDatos);
			contentPane.setLayout(null);
			
			listFuncionDeGregario = new JList<String>();
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
			listFuncionDeGregario.setBounds(248, 225, 165, 100);
			listFuncionDeGregario.setVisible(false);
			contentPane.add(listFuncionDeGregario);
			
			lblListaGregario = new JLabel("Función en el Peloton:");
			lblListaGregario.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblListaGregario.setBounds(245, 194, 272, 23);
			lblListaGregario.setVisible(false);
			contentPane.add(lblListaGregario);

	}
}
