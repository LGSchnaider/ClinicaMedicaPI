package model;

public class MDoctor extends MPerson {

	private String uf;
	private Long crm;
	private MUser user;
	
	
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}



	public MDoctor() {
		this.user = new MUser();
	}

	public MUser getUsuario() {
		return user;
	}

	public void setUsuario(MUser usuario) {
		this.user = usuario;
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
