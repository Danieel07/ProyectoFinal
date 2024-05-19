package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.EscuadraDTO;

/**
 * La clase ModelFacade contiene la informacion con respecto a la inicializacion
 * de los DAO.
 */

public class ModelFacade {
	private DirectorDeportivoDAO ddDAO;
	private CiclistaDAO cDAO;
	private MasajistaDAO mDAO;
	private UsuarioDAO uDAO;
	private EscuadraDAO eDAO;

	/**
	 * Constructor de la clase ModelFacade que inicializa los DAO.
	 */

	public ModelFacade() {
		ddDAO = new DirectorDeportivoDAO();
		cDAO = new CiclistaDAO();
		mDAO = new MasajistaDAO();
		uDAO = new UsuarioDAO();
		eDAO = new EscuadraDAO();
	}

	/**
	 * Obtiene el DirectorDeportivoDAO.
	 * 
	 * @return ddDAO.
	 */

	public DirectorDeportivoDAO getDdDAO() {
		return ddDAO;
	}

	/**
	 * Obtiene el CiclistaDAO.
	 * 
	 * @return cDAO.
	 */

	public CiclistaDAO getcDAO() {
		return cDAO;
	}

	/**
	 * Obtiene el MasajitaDAO.
	 * 
	 * @return eDAO.
	 */

	public MasajistaDAO getmDAO() {
		return mDAO;
	}

	/**
	 * Obtiene el UsuarioDAO.
	 * 
	 * @return uDAO.
	 */

	public UsuarioDAO getuDAO() {
		return uDAO;
	}

	public EscuadraDAO geteDAO() {
		return eDAO;
	}
	

}
