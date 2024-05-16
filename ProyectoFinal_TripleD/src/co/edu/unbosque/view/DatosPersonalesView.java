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
	
	public DatosPersonalesView() {
		setBounds(new Rectangle(0, 0, 1076, 681));
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(30, 30, 118, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(40, 55, 165, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCedula.setBounds(30, 86, 118, 14);
		add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(40, 111, 165, 20);
		add(txtCedula);
		
		JLabel lblAosDeExperiencia = new JLabel("Años de Experiencia:");
		lblAosDeExperiencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAosDeExperiencia.setBounds(30, 142, 175, 14);
		add(lblAosDeExperiencia);
		
		txtAnosExperiencia = new JTextField();
		txtAnosExperiencia.setColumns(10);
		txtAnosExperiencia.setBounds(40, 167, 165, 20);
		add(txtAnosExperiencia);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNacionalidad.setBounds(30, 198, 175, 14);
		add(lblNacionalidad);
		
		JScrollPane scrollPaneNacionalidad = new JScrollPane();
		scrollPaneNacionalidad.setBounds(40, 223, 165, 80);
		add(scrollPaneNacionalidad);
		
			JList<String> listNacionalidad = new JList<String>();
			listNacionalidad.setModel(new AbstractListModel<String>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				String[] values = new String[] {"Argelia", "Angola", "Benín", "Botsuana", "Burkina Faso", "Burundi", "Cabo Verde", "Camerún", "Chad", "Comoras", "Costa de Marfil", "Egipto", "Eritrea", "Etiopía", "Gabón", "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Guinea Ecuatorial", "Kenia", "Lesoto", "Liberia", "Libia", "Madagascar", "Malaui", "Malí", "Marruecos", "Mauricio", "Mauritania", "Mozambique", "Namibia", "Níger", "Nigeria", "República Centroafricana", "República Democrática del Congo", "República del Congo", "Ruanda", "Santo Tomé y Príncipe", "Senegal", "Seychelles", "Sierra Leona", "Somalia", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur", "Tanzania", "Togo", "Túnez", "Uganda", "Yibuti", "Zambia", "Zimbabue", "Antigua y Barbuda", "Argentina", "Bahamas", "Barbados", "Belice", "Bolivia", "Brasil", "Canadá", "Chile", "Colombia", "Costa Rica", "Cuba", "Dominica", "Ecuador", "El Salvador", "Estados Unidos", "Granada", "Guatemala", "Guyana", "Haití", "Honduras", "Jamaica", "México", "Nicaragua", "Panamá", "Paraguay", "Perú", "República Dominicana", "San Cristóbal y Nieves", "San Vicente y las Granadinas", "Santa Lucía", "Surinam", "Trinidad y Tobago", "Uruguay", "Venezuela", "Afganistán", "Arabia Saudita", "Armenia", "Azerbaiyán", "Bangladés", "Baréin", "Birmania (Myanmar)", "Brunéi", "Bután", "Camboya", "Catar", "China", "Chipre", "Corea del Norte", "Corea del Sur", "Emiratos Árabes Unidos", "Filipinas", "Georgia", "India", "Indonesia", "Irak", "Irán", "Israel", "Japón", "Jordania", "Kazajistán", "Kirguistán", "Kuwait", "Laos", "Líbano", "Malasia", "Maldivas", "Mongolia", "Nepal", "Omán", "Pakistán", "Palestina", "Papúa Nueva Guinea", "Filipinas", "Qatar", "Rusia", "Singapur", "Siria", "Sri Lanka", "Tailandia", "Tayikistán", "Timor Oriental", "Turkmenistán", "Turquía", "Uzbekistán", "Vietnam", "Yemen", "Albania", "Alemania", "Andorra", "Austria", "Bélgica", "Bielorrusia", "Bosnia y Herzegovina", "Bulgaria", "Chipre", "Ciudad del Vaticano", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia", "Hungría", "Irlanda", "Islandia", "Italia", "Letonia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte", "Malta", "Moldavia", "Mónaco", "Montenegro", "Noruega", "Países Bajos", "Polonia", "Portugal", "Reino Unido", "República Checa", "Rumania", "Rusia", "San Marino", "Serbia", "Suecia", "Suiza", "Ucrania", "Australia", "Fiyi", "Islas Marshall", "Islas Salomón", "Kiribati", "Micronesia", "Nauru", "Nueva Zelanda", "Palau", "Papúa Nueva Guinea", "Samoa", "Tonga", "Tuvalu", "Vanuatu", "Territorio Antártico Británico", "Territorio Antártico Chileno", "Territorio Antártico Argentino", "Territorio Antártico Australiano", "Territorio Antártico Francés", "Territorio Antártico Neozelandés", "Territorio Antártico Noruego"};
				public int getSize() {
					return values.length;
				}
				public String getElementAt(int index) {
					return values[index];
				}
			});
			
			listNacionalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPaneNacionalidad.setColumnHeaderView(listNacionalidad);
		
		JLabel lblTipoDeCiclista = new JLabel("Tipo De Ciclista:");
		lblTipoDeCiclista.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeCiclista.setBounds(30, 314, 175, 14);
		add(lblTipoDeCiclista);
		
		JScrollPane scrollPaneTipoCiclista = new JScrollPane();
		scrollPaneTipoCiclista.setBounds(40, 337, 165, 80);
		add(scrollPaneTipoCiclista);
		
		JList<String> listTipoCiclista = new JList<String>();
		listTipoCiclista.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Escaladores", "Rodadores", "Sprinters o embaladores", "Gregarios", "Clasicómanos", "Contrarrelojista"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listTipoCiclista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTipoCiclista.setColumnHeaderView(listTipoCiclista);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(40, 453, 165, 20);
		add(txtEspecialidad);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecialidad.setBounds(30, 428, 118, 14);
		add(lblEspecialidad);
		
		txtContextura = new JTextField();
		txtContextura.setColumns(10);
		txtContextura.setBounds(40, 509, 165, 20);
		add(txtContextura);
		
		JLabel lblContextura = new JLabel("Contextura:");
		lblContextura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContextura.setBounds(30, 484, 118, 14);
		add(lblContextura);
		
		JLabel lblCadenciaDePedaleo = new JLabel("Cadencia de pedaleo");
		lblCadenciaDePedaleo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadenciaDePedaleo.setBounds(30, 540, 175, 14);
		add(lblCadenciaDePedaleo);
		
		txtCadenciaPedaleo = new JTextField();
		txtCadenciaPedaleo.setColumns(10);
		txtCadenciaPedaleo.setBounds(40, 565, 165, 20);
		add(txtCadenciaPedaleo);

	}
}
