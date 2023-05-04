package modelo;

public class Medico extends Pessoa {

	private String uf;
	private Long crm;
	private Usuario usuario;
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}



	public Medico() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
	

/*	public boolean equals(Object obj) {
		Medico m = (Medico) obj;
		if(m.id == id) {
			return true;
		}else
			return false;
	}*/

}
