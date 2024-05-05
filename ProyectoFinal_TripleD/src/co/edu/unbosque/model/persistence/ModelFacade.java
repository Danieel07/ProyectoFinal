package co.edu.unbosque.model.persistence;

/**
 * La clase ModelFacade contiene la informacion con respecto a la inicializacion
 * de los DAO.
 */

public class ModelFacade {
	private DirectorDeportivoDAO ddDAO;
	private CiclistaDAO cDAO;
	private EquipoDAO eDAO;
	private MasajistaDAO mDAO;
	private UsuarioDAO uDAO;

	/**
	 * Constructor de la clase ModelFacade que inicializa los DAO.
	 */

	public ModelFacade() {
		ddDAO = new DirectorDeportivoDAO();
		cDAO = new CiclistaDAO();
		eDAO = new EquipoDAO();
		mDAO = new MasajistaDAO();
		uDAO = new UsuarioDAO();
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
	 * Obtiene el EquipoDAO.
	 * 
	 * @return eDAO.
	 */

	public EquipoDAO geteDAO() {
		return eDAO;
	}

	/**
	 * Obtiene el MasajistaDAO.
	 * 
	 * @return mDAO.
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

}
