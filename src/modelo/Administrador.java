package modelo;

public class Administrador {

	private String login;
	private String senha;
	private int pefil;
	private int id;

	public int getIdusuario() {
		return id;
	}

	public void setIdusuario(int idusuario) {
		this.id = idusuario;
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

}
