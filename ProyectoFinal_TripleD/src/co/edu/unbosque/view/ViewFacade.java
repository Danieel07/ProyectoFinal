package co.edu.unbosque.view;

public class ViewFacade {
	private LoginView loginView;
	private RegistroView registroView;
	public ViewFacade() {
		loginView = new LoginView();
		registroView = new RegistroView();
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public RegistroView getRegistroView() {
		return registroView;
	}
}

