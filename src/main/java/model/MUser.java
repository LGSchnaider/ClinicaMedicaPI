package model;

public class MUser {

	private String login;
	private String password;
	private int profile;
	private int id;

	public int getIdusuario() {
		return id;
	}

	public void setIdusuario(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return password;
	}

	public void setSenha(String senha) {
		this.password = senha;
	}

	public int getPerfil() {
		return profile;
	}

	public void setPefil(int pefil) {
		this.profile = pefil;
	}

}
