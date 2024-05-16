package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class DatosPersonalesView extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtAnosExperiencia;
	public JTextField txtEspecialidad;
	public JTextField txtContextura;
	public JTextField txtCadenciaPedaleo;
	private JTextField txtNacionalidad;
	
	public DatosPersonalesView() {
		setBounds(new Rectangle(0, 0, 1076, 681));
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 30, 118, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(40, 55, 165, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(30, 86, 118, 14);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(40, 111, 165, 20);
		txtCedula.setColumns(10);
		add(txtCedula);
		
		JLabel lblAosDeExperiencia = new JLabel("Años de Experiencia:");
		lblAosDeExperiencia.setBounds(30, 142, 175, 14);
		lblAosDeExperiencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblAosDeExperiencia);
		
		txtAnosExperiencia = new JTextField();
		txtAnosExperiencia.setBounds(40, 167, 165, 20);
		txtAnosExperiencia.setColumns(10);
		add(txtAnosExperiencia);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(30, 198, 175, 14);
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNacionalidad);
		
		JLabel lblTipoDeCiclista = new JLabel("Tipo De Ciclista:");
		lblTipoDeCiclista.setBounds(30, 254, 175, 14);
		lblTipoDeCiclista.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblTipoDeCiclista);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(40, 429, 165, 20);
		txtEspecialidad.setColumns(10);
		add(txtEspecialidad);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(30, 404, 118, 14);
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblEspecialidad);
		
		txtContextura = new JTextField();
		txtContextura.setBounds(40, 485, 165, 20);
		txtContextura.setColumns(10);
		add(txtContextura);
		
		JLabel lblContextura = new JLabel("Contextura:");
		lblContextura.setBounds(30, 460, 118, 14);
		lblContextura.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblContextura);
		
		JLabel lblCadenciaDePedaleo = new JLabel("Cadencia de pedaleo");
		lblCadenciaDePedaleo.setBounds(30, 516, 175, 14);
		lblCadenciaDePedaleo.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblCadenciaDePedaleo);
		
		txtCadenciaPedaleo = new JTextField();
		txtCadenciaPedaleo.setBounds(40, 541, 165, 20);
		txtCadenciaPedaleo.setColumns(10);
		add(txtCadenciaPedaleo);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(40, 223, 165, 20);
		txtNacionalidad.setColumns(10);
		add(txtNacionalidad);
		
		JList listTipoDeCiclista = new JList();
		listTipoDeCiclista.setBounds(40, 279, 165, 123);
		listTipoDeCiclista.setModel(new AbstractListModel() {
			String[] values = new String[] {"Escaladores", "Rodadores", "Sprinters o embaladores", "Gregarios", "Clasicómanos", "Contrarrelojista"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(listTipoDeCiclista);

	}
}
