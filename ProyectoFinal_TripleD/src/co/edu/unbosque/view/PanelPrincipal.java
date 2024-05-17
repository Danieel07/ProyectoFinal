package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblBienvenido;
	public JLabel lblRol;
	public JButton btnGenerarReporte;
	public JButton btnSimularCarrera;
	public JButton btnCrearEscuadra;
	public JButton btnEscuadra;
	public JButton btnRegresar;
	public JButton btnLlenarDatos;

	public PanelPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 25, 628, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 192));
		panelMenu.setBounds(0, 0, 612, 681);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		lblBienvenido = new JLabel("Name");
		lblBienvenido.setForeground(new Color(255, 255, 255));
		lblBienvenido.setBounds(10, 11, 244, 14);
		panelMenu.add(lblBienvenido);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(new Color(255, 255, 255));
		btnRegresar.setBorder(null);
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegresar.setBackground(new Color(0, 82, 164));
		btnRegresar.setBounds(174, 415, 264, 41);
		panelMenu.add(btnRegresar);
		
		btnLlenarDatos = new JButton("Datos Personales");
		btnLlenarDatos.setForeground(Color.WHITE);
		btnLlenarDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLlenarDatos.setBorder(null);
		btnLlenarDatos.setBackground(new Color(0, 82, 164));
		btnLlenarDatos.setBounds(174, 104, 264, 41);
		panelMenu.add(btnLlenarDatos);
		
		JLabel lblMenu = new JLabel("Menu:");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenu.setBounds(184, 72, 244, 14);
		panelMenu.add(lblMenu);
		
		btnEscuadra = new JButton("Escuadra");
		btnEscuadra.setForeground(Color.WHITE);
		btnEscuadra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEscuadra.setBorder(null);
		btnEscuadra.setBackground(new Color(0, 82, 164));
		btnEscuadra.setBounds(174, 168, 264, 41);
		panelMenu.add(btnEscuadra);
		
		btnCrearEscuadra = new JButton("Crear Escuadra");
		btnCrearEscuadra.setForeground(Color.WHITE);
		btnCrearEscuadra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrearEscuadra.setBorder(null);
		btnCrearEscuadra.setBackground(new Color(0, 82, 164));
		btnCrearEscuadra.setBounds(174, 231, 264, 41);
		panelMenu.add(btnCrearEscuadra);
		
		btnSimularCarrera = new JButton("Simular Carrera");
		btnSimularCarrera.setForeground(Color.WHITE);
		btnSimularCarrera.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSimularCarrera.setBorder(null);
		btnSimularCarrera.setBackground(new Color(0, 82, 164));
		btnSimularCarrera.setBounds(174, 293, 264, 41);
		panelMenu.add(btnSimularCarrera);
		
		btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setForeground(Color.WHITE);
		btnGenerarReporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerarReporte.setBorder(null);
		btnGenerarReporte.setBackground(new Color(0, 82, 164));
		btnGenerarReporte.setBounds(174, 354, 264, 41);
		panelMenu.add(btnGenerarReporte);
		
		lblRol = new JLabel("Rol");
		lblRol.setForeground(Color.WHITE);
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRol.setBounds(10, 36, 244, 25);
		panelMenu.add(lblRol);
	}
}
