package co.edu.unbosque.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.persistence.ModelFacade;
import javax.swing.ListSelectionModel;

public class CrearEscuadraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtAniosExperiencia;
	public JTextField txtNacionalidad;
	public JTextField txtTipoCiclista;
	public JTextField txtEspecialidad;
	public JTextField txtContextura;
	public JTextField txtCadenciaPedaleo;
	
	
	public JTextField txtAtributoExtra1;
	public JTextField txtAtributoExtra2;
	public JTextField txtAtributoExtra3;
	
	
	public JLabel lblAtributoExtra1;
	public JLabel lblAtributoExtra2;
	public JLabel lblAtributoExtra3;
	
	
	public JButton btnAgregar;
	public JButton btnEliminar;
	public JTable tablaEscuadra;
	public JButton btnRegresarPanelPrincipal;
	public JTable tableCiclistas;
	private DefaultTableModel model;
	private ModelFacade modelFacade;
	public JButton btnSelecionar;
	public JButton btnCrear;
	public JTextField txtTiempoAcumulado;
	public DefaultTableModel modelTablaEscuadra;

	/**
	 * Create the frame.
	 */
	public CrearEscuadraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 298, 118, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 320, 165, 20);
		contentPane.add(txtNombre);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCedula.setBounds(10, 351, 118, 14);
		contentPane.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(10, 376, 165, 20);
		contentPane.add(txtCedula);
		
		txtAniosExperiencia = new JTextField();
		txtAniosExperiencia.setColumns(10);
		txtAniosExperiencia.setBounds(10, 440, 165, 20);
		contentPane.add(txtAniosExperiencia);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(253, 320, 165, 20);
		contentPane.add(txtNacionalidad);
		
		txtTipoCiclista = new JTextField();
		txtTipoCiclista.setColumns(10);
		txtTipoCiclista.setBounds(253, 376, 165, 20);
		contentPane.add(txtTipoCiclista);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(253, 440, 165, 20);
		contentPane.add(txtEspecialidad);
		
		JLabel lblAosDeExperiencia = new JLabel("Años de Experiencia:");
		lblAosDeExperiencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAosDeExperiencia.setBounds(10, 419, 175, 14);
		contentPane.add(lblAosDeExperiencia);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNacionalidad.setBounds(253, 300, 175, 14);
		contentPane.add(lblNacionalidad);
		
		JLabel lblTipoDeCiclista = new JLabel("Tipo De Ciclista:");
		lblTipoDeCiclista.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeCiclista.setBounds(253, 351, 175, 14);
		contentPane.add(lblTipoDeCiclista);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecialidad.setBounds(253, 421, 118, 14);
		contentPane.add(lblEspecialidad);
		
		txtContextura = new JTextField();
		txtContextura.setColumns(10);
		txtContextura.setBounds(460, 320, 165, 20);
		contentPane.add(txtContextura);
		
		txtCadenciaPedaleo = new JTextField();
		txtCadenciaPedaleo.setColumns(10);
		txtCadenciaPedaleo.setBounds(460, 376, 165, 20);
		contentPane.add(txtCadenciaPedaleo);
		
		txtAtributoExtra3 = new JTextField();
		txtAtributoExtra3.setVisible(false);
		txtAtributoExtra3.setColumns(10);
		txtAtributoExtra3.setBounds(662, 440, 165, 20);
		contentPane.add(txtAtributoExtra3);
		
		txtAtributoExtra1 = new JTextField();
		txtAtributoExtra1.setVisible(false);
		txtAtributoExtra1.setColumns(10);
		txtAtributoExtra1.setBounds(662, 320, 165, 20);
		contentPane.add(txtAtributoExtra1);
		
		JLabel lblContextura = new JLabel("Contextura:");
		lblContextura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContextura.setBounds(462, 300, 118, 14);
		contentPane.add(lblContextura);
		
		JLabel lblCadenciaDePedaleo = new JLabel("Cadencia de pedaleo:");
		lblCadenciaDePedaleo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadenciaDePedaleo.setBounds(460, 353, 175, 14);
		contentPane.add(lblCadenciaDePedaleo);
		
		txtAtributoExtra2 = new JTextField();
		txtAtributoExtra2.setVisible(false);
		txtAtributoExtra2.setColumns(10);
		txtAtributoExtra2.setBounds(662, 376, 165, 20);
		contentPane.add(txtAtributoExtra2);
		
		lblAtributoExtra1 = new JLabel("Extra 1:");
		lblAtributoExtra1.setVisible(false);
		lblAtributoExtra1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtributoExtra1.setBounds(662, 300, 277, 14);
		contentPane.add(lblAtributoExtra1);
		
		lblAtributoExtra2 = new JLabel("Extra 2:");
		lblAtributoExtra2.setVisible(false);
		lblAtributoExtra2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtributoExtra2.setBounds(662, 355, 277, 14);
		contentPane.add(lblAtributoExtra2);
		
		lblAtributoExtra3 = new JLabel("Extra 3:");
		lblAtributoExtra3.setVisible(false);
		lblAtributoExtra3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtributoExtra3.setBounds(662, 421, 301, 14);
		contentPane.add(lblAtributoExtra3);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(436, 54, 99, 32);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(436, 97, 99, 28);
		contentPane.add(btnEliminar);
		
		btnRegresarPanelPrincipal = new JButton("Regresar");
		btnRegresarPanelPrincipal.setBounds(436, 248, 99, 32);
		contentPane.add(btnRegresarPanelPrincipal);
		
		
		tablaEscuadra = new JTable();
		tablaEscuadra.setBounds(558, 11, 427, 269);
		modelTablaEscuadra = new DefaultTableModel();
		tablaEscuadra.setModel(modelTablaEscuadra);
		modelTablaEscuadra.addColumn("Nombre");
		modelTablaEscuadra.addColumn("Cedula");
		modelTablaEscuadra.addColumn("Años De Experiencia");
		modelTablaEscuadra.addColumn("Tipo De Ciclista");
		modelTablaEscuadra.addColumn("Nacionalidad");
		modelTablaEscuadra.addColumn("Contextura");
		modelTablaEscuadra.addColumn("Tiempo Acumulado");
		modelTablaEscuadra.addColumn("Especialidad");
		
		contentPane.add(tablaEscuadra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 408, 258);
		contentPane.add(scrollPane);
		
		tableCiclistas = new JTable();
		tableCiclistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		tableCiclistas.setModel(model);
		model.addColumn("Nombre");
		model.addColumn("Cedula");
		model.addColumn("Años De Experiencia");
		model.addColumn("Tipo De Ciclista");
		model.addColumn("Nacionalidad");
		model.addColumn("Contextura");
		model.addColumn("Tiempo Acumulado");
		model.addColumn("Especialidad");
		llenarTabla();
		
		scrollPane.setViewportView(tableCiclistas);
		
		btnSelecionar = new JButton("Seleccionar");
		btnSelecionar.setBounds(436, 136, 99, 32);
		contentPane.add(btnSelecionar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(436, 178, 99, 32);
		contentPane.add(btnCrear);
		
		JLabel lblTiempoAcumulado = new JLabel("Tiempo Acumulado");
		lblTiempoAcumulado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTiempoAcumulado.setBounds(460, 417, 175, 14);
		contentPane.add(lblTiempoAcumulado);
		
		txtTiempoAcumulado = new JTextField();
		txtTiempoAcumulado.setColumns(10);
		txtTiempoAcumulado.setBounds(460, 440, 165, 20);
		contentPane.add(txtTiempoAcumulado);
	}
	
	private void llenarTabla() {
		modelFacade =  new ModelFacade();
		ArrayList<CiclistaDTO> lista = modelFacade.getcDAO().getLista();
		for (CiclistaDTO ciclista : lista) {
			Object[] fila = new Object[8];
			fila[0] = ciclista.getNombre();
			fila[1] = ciclista.getIdentificador();
			fila[2] = ciclista.getAniosExp();
			fila[3] = ciclista.getTipoCiclista();
			fila[4] = ciclista.getNacionalidad();
			fila[5] = ciclista.getContextura();
			fila[6] = ciclista.getTiempoAcumulado();
			fila[7] = ciclista.getEspecialidad();
			model.addRow(fila);
		}
	
	}
}
