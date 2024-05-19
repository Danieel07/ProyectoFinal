package co.edu.unbosque.view;

/**
 * La clase ViewFacade contiene la informacion de la creacion e inicializacion
 * de los paneles de la vista.
 */

public class ViewFacade {
	private LoginView loginView;
	private RegistroView registroView;
	private PanelPrincipal panelPrincipal;
	private DatosPersonalesView datosPersonalesView;
	private CrearEscuadraView crearEscuadraView;
	private EscuadraView escuadraView;
	
	/**
	 * El constructor de la clase ViewFacade contiene la inicializacion de los
	 * paneles de la vista del aplicativo.
	 */

	public ViewFacade() {
		loginView = new LoginView();
		registroView = new RegistroView();
		panelPrincipal =  new PanelPrincipal();
		datosPersonalesView = new DatosPersonalesView();
		crearEscuadraView = new CrearEscuadraView();
		escuadraView =  new EscuadraView();
	}

	public CrearEscuadraView getCrearEscuadraView() {
		return crearEscuadraView;
	}

	/**
	 * Obtiene el LoginView.
	 * 
	 * @return loginView.
	 */

	public LoginView getLoginView() {
		return loginView;
	}

	/**
	 * Obtiene el RegistroView.
	 * 
	 * @return RegistroView.
	 */

	public RegistroView getRegistroView() {
		return registroView;
	}
	
	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}
	
	public DatosPersonalesView getDatosPersonalesView() {
		return datosPersonalesView;
	}

	public EscuadraView getEscuadraView() {
		return escuadraView;
	}

}
