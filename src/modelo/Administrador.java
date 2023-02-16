package modelo;

public class Administrador {

	private String login;
	private String senha;
	private int pefil;
	private boolean admin;

	private int idusuario;

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPefil() {
		return pefil;
	}

	public void setPefil(int pefil) {
		this.pefil = pefil;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
