package co.edu.unbosque.model.persistence;

public class ModelFacade {
	private DirectorDeportivoDAO ddDAO;
	private CiclistaDAO cDAO;
	private EquipoDAO eDAO;
	private MasajistaDAO mDAO;
	private UsuarioDAO uDAO;
	
	public ModelFacade() {
		ddDAO = new DirectorDeportivoDAO();
		cDAO = new CiclistaDAO();
		eDAO = new EquipoDAO();
		mDAO = new MasajistaDAO();
		uDAO = new UsuarioDAO();
	}
	public DirectorDeportivoDAO getDdDAO() {
		return ddDAO;
	}
	public CiclistaDAO getcDAO() {
		return cDAO;
	}
	public EquipoDAO geteDAO() {
		return eDAO;
	}
	public MasajistaDAO getmDAO() {
		return mDAO;
	}
	public UsuarioDAO getuDAO() {
		return uDAO;
	}
	
}
