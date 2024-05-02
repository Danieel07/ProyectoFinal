package co.edu.unbosque.view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblClave;
	public JTextField txtUsuario;
	public JTextField txtClave;
	public JLabel lblRegistro;
	public JButton btnInicioSesion;

	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 453, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Inición de Sesión");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(157, 32, 154, 15);
		lblTitulo.setForeground(getBackground().black);
		contentPane.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 58, 227, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsuario.setBounds(63, 24, 100, 15);
			lblUsuario.setForeground(getBackground().black);
			panel.add(lblUsuario);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(13, 44, 200, 25);
			panel.add(txtUsuario);
			
			lblClave = new JLabel("Contraseña:");
			lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblClave.setHorizontalAlignment(SwingConstants.CENTER);
			lblClave.setBounds(63, 94, 100, 15);
			lblClave.setForeground(getBackground().black);
			panel.add(lblClave);
			
			txtClave = new JTextField();
			txtClave.setBounds(13, 114, 200, 25);
			panel.add(txtClave);
			
			lblRegistro = new JLabel("Registrarse");
			lblRegistro.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RegistroView rv = new RegistroView();
					rv.setVisible(true);
					dispose();
				}
			});
			
			lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistro.setBounds(63, 150, 100, 15);
			lblRegistro.setForeground(new Color(255, 0, 0));
			
			panel.add(lblRegistro);
			
			btnInicioSesion = new JButton("Inicar Sesión");
			btnInicioSesion.setForeground(new Color(0, 128, 255));
			btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnInicioSesion.setBounds(169, 264, 97, 36);
			contentPane.add(btnInicioSesion);
		
	}
}
