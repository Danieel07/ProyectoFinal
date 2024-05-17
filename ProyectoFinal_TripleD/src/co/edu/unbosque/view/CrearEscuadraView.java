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
import java.awt.event.ActionEvent;

public class CrearEscuadraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblExtra;
	private JLabel lblExtra_1;
	private JLabel lblExtra_2;
	private JButton btnNewButton;
	private JButton btnActualizar;
	private JButton btnEliminar;

	/**
	 * Create the frame.
	 */
	public CrearEscuadraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 614, 269);
		contentPane.add(table);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 298, 118, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 320, 165, 20);
		contentPane.add(textField);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCedula.setBounds(10, 351, 118, 14);
		contentPane.add(lblCedula);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 376, 165, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 440, 165, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(253, 320, 165, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(253, 376, 165, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(253, 440, 165, 20);
		contentPane.add(textField_5);
		
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
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(460, 320, 165, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(460, 376, 165, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(662, 440, 165, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(662, 320, 165, 20);
		contentPane.add(textField_9);
		
		JLabel lblContextura = new JLabel("Contextura:");
		lblContextura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContextura.setBounds(462, 300, 118, 14);
		contentPane.add(lblContextura);
		
		JLabel lblCadenciaDePedaleo_1 = new JLabel("Cadencia de pedaleo:");
		lblCadenciaDePedaleo_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadenciaDePedaleo_1.setBounds(460, 353, 175, 14);
		contentPane.add(lblCadenciaDePedaleo_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(662, 376, 165, 20);
		contentPane.add(textField_10);
		
		lblExtra = new JLabel("Extra 1:");
		lblExtra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExtra.setBounds(662, 300, 118, 14);
		contentPane.add(lblExtra);
		
		lblExtra_1 = new JLabel("Extra 2:");
		lblExtra_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExtra_1.setBounds(662, 355, 118, 14);
		contentPane.add(lblExtra_1);
		
		lblExtra_2 = new JLabel("Extra 3:");
		lblExtra_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExtra_2.setBounds(662, 421, 118, 14);
		contentPane.add(lblExtra_2);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(662, 85, 99, 32);
		contentPane.add(btnNewButton);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setBounds(662, 128, 99, 28);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(662, 167, 99, 28);
		contentPane.add(btnEliminar);
	}
}
