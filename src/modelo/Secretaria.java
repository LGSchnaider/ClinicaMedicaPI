package modelo;

public class Secretaria {
	
	private String nome;
	private long cpf;
	private long telefone;
	private String email;
	private Usuario usuario;
	
	public Secretaria() {
		this.usuario = new Usuario();
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
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

}
