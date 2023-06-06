package model;

public class MSecretary extends MPerson {

	private long telephone;
	private String email;
	private MUser user;
	private String login;
	private String password;
	
	
	
	public String getSenha() {
		return password;
	}
	public void setSenha(String senha) {
		this.password = senha;
	}
	public MSecretary() {
		this.user = new MUser();
	}
	public void setUsuario(MUser usuario) {
		this.user = usuario;
	}
	public MUser getUsuario() {
		return user;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getTelefone() {
		return telephone;
	}

	public void setTelefone(long telefone) {
		this.telephone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

}
