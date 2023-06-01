package modelo;

public class MSecretary extends MPerson {

	private long telefone;
	private String email;
	private MUser usuario;
	private String login;
	private String senha;
	
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public MSecretary() {
		this.usuario = new MUser();
	}
	public void setUsuario(MUser usuario) {
		this.usuario = usuario;
	}
	public MUser getUsuario() {
		return usuario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
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
